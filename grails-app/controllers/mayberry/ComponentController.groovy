package mayberry
import groovyx.net.http.*
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
class ComponentController {
    def componentService
    def squadService
    def index() { 
        def list = componentService.list() ///Component.list()
        render(view:'index',model:[components:list])
    }
    def create(){
        //https://gitlab.com/heptorsj/spring-seed.git
        //String seed = "18967563"
        String seed = ""
        def tech = params.framework
        def squads = squadService.list()
        switch(tech) {
            case "Spring":
                seed = "56"
            break
            case "Flask":
                seed = "87"
            break
            default:
                seed = "XX"
            break
        }
        [seed: seed ,framework: tech, squads: squads]
    }
    def getNodes(Long id_c1){
        int id = 1
        def colorMap = [1:"red",2:"green",3:"blue",4:"purple"]
        def direccion = ["red":"to","green":"to","blue":"to","purple":"from"]
        def nodes = Dependency.all.findAll {
            it.idC1 == id_c1 || it.idC2 == id_c1
        }
        def uniques  = []
        def uniquesedges = []
        def colors = []
        def details = []
        nodes.each {
            uniques.add(it.idC1)
            uniques.add(it.idC2)
            def route = [it.idC1,it.idC2]
            uniquesedges.add(route)
            colors.add(colorMap[it.grade])
            details.add(it.detail)
        }
        uniquesedges = uniquesedges.toSet()
        def djson = []
        def ejson = []
        def mapn = [:]
        uniques.toSet().each {
            def comp = Component.all.find { c -> 
                c.id == it
            }
            def object = JsonOutput.toJson([id: id, label: "${comp.name}"])
            mapn[it] = id
            djson.add(object)
            id += 1
        }
        def iterator = 0
        uniquesedges.each { arr -> 
            def colorjson = JsonOutput.toJson([color: colors.get(iterator)])
            def arrow = direccion[colors.get(iterator)]
            def route = JsonOutput.toJson([from: mapn.get(arr[0]), to: mapn.get(arr[1]),color:colorjson,arrows:arrow] )
            ejson.add(route)
            iterator += 1
        }
       
        
        return [JsonOutput.toJson(djson),JsonOutput.toJson(ejson)]
    }
    def getAllNodes(Long id_c1){
        int id = 1
        def colorMap = [1:"red",2:"green",3:"blue",4:"purple"]
        def direccion = ["red":"to","green":"to","blue":"to","purple":"from"]
        def nodes = Dependency.all.findAll {
            it.idC1 == id_c1
        }
        def uniques  = []
        def uniquesedges = []
        def colors = []
        def details = []
        nodes.each {
            uniques.add(it.idC1)
            uniques.add(it.idC2)
            def route = [it.idC1,it.idC2]
            colors.add(colorMap[it.grade])
            uniquesedges.add(route)
            details.add(it.detail)
        }
        uniquesedges = uniquesedges.toSet()
        def djson = []
        def ejson = []
        def mapn = [:]
        uniques.toSet().each {
            def comp = Component.all.find { c -> 
                c.id == it
            }
            def object = [id: id, label: "${comp.name}"]
            mapn[it] = id
            djson.add(object)
            id += 1
        }
        def ite = 0
        uniquesedges.each { arr -> 
            def dir = colors.get(ite)
            def arrows = direccion[dir]
            def detail = details.get(ite)
            def route = [from: arr[0], to: arr[1],color:colors.get(ite),arrows: arrows,detail:detail]
            ejson.add(route)
            ite += 1
        }
       
        
        return [djson,ejson]
    }
    def view(Long id){
        def component = componentService.get(id)
        def nodes = getNodes(id)[0]
        def edges = getNodes(id)[1]
        render(view:'view',model:[component:component , nodes: nodes, edges: edges])
    }
    def newComponent(){
        // here the component is created
        def name = params.name
        def url = params.url
        def port = params.port
        def dname = params.discoverName
        def squad = params.idSquad
        def token = params.token
        def seed = "no seed"
        def gitlaburl = params.giturl
        def url_development = params.url_development
        def port_development = params.port_development
        if (!gitlaburl.isEmpty()){
            def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad,gitlab: gitlaburl,url_development: url_development, port_development: port_development)
            service.save()
        }else{
            if( seed == null){
                 def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad,gitlab: gitlaburl,url_development: url_development, port_development: port_development)
                 service.save()
            }else{
                StringBuilder result = new StringBuilder();
                def code = 0
                HttpURLConnection urlConnection;
                def urlParameters  = "?path=${name}&name=${name}";
                URL gitUrl = new URL("https://192.168.100.236/api/v4/projects/$seed/fork$urlParameters");
                urlConnection = (HttpURLConnection) gitUrl.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Private-Token", token);
                InputStream ino = new BufferedInputStream(urlConnection.getInputStream());
                code = urlConnection.getResponseCode();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ino));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                def texto = result.toString();
                def slurper = new groovy.json.JsonSlurper()
                def json = slurper.parseText(texto)
                def gitlink = json.http_url_to_repo
                def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad,gitlab: gitlink, url_development: url_development, port_development: port_development)
                service.save()    
                }
            
        }
        def mensaje = "Component  ${name} created"
        def list = componentService.list() ///Component.list()
        // forking the project fork?name=${name}&path=${name}
        //def http = new HTTPBuilder('http://gitlab.com/')
        //example request 
        //curl --request POST   --header "PRIVATE-TOKEN:<token>" 
        //"https://gitlab.com/api/v4/projects/18967563/fork?path=test&name=test"
        render(view:'index',model:[components:list, mensaje: mensaje])
    }
    def delete(Long id){
        componentService.delete(id)
        def code = 200
        def texto = "Component Deleted."
        def list = componentService.list()
        def mensaje = "Success"
        render(view:'index',model:[components:list, mensaje: mensaje, result:texto, code:code])
    }
    def update(Long id){
        def component = componentService.get(id)
        def squads = squadService.list()
        def nodes = getNodes(id)[0]
        def edges = getNodes(id)[1]
        render(view:'update',model:[component:component , nodes: nodes, edges: edges, squads: squads])
    }

    def updateComponent(){
        def id = Integer.parseInt(params.id)
        def component = componentService.get(id)
        def list = componentService.list() ///Component.list()
        // here the component is created
        def name = params.name
        def url = params.url
        def port = params.port
        def dname = params.discoverName
        def squad = params.idSquad
        def gitlaburl = params.giturl
        def url_development = params.url_development
        def port_development = params.port_development
        component.url = url
        component.name = name
        component.port = Integer.parseInt(port)
        component.discoverName = dname
        component.idSquad = Integer.parseInt(squad)
        component.gitlab = gitlaburl
        component.url_development = url_development
        component.port_development = Integer.parseInt(port_development)
        componentService.update(component)
        def mensaje = " Component Updated! "
        render(view:'index',model:[components:list, mensaje: mensaje])
    }
    def overview(){
        def components = componentService.list()
        def nodes = []
        def edges = []
        def medges = [:].withDefault {[]}
        components.each {
            nodes.add(JsonOutput.toJson([id: it.id, label: it.name]))
            def maps = getAllNodes(it.id)[1]
            maps.each { route ->  
                def from = route.from
                def to = route.to
                def color = route.color
                def arrow = route.arrows
                def detail = route.detail
                medges[from].add(to)
                edges.add(JsonOutput.toJson([from: from, to:to,color:color,arrows:arrow,detail:detail] ))
            }
        }
        render(view:'overview',model:[nodes: JsonOutput.toJson(nodes), edges: JsonOutput.toJson(edges)])
    }
}
