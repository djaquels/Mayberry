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
        def nodes = Dependency.all.findAll {
            it.idC1 == id_c1 || it.idC2 == id_c1
        }
        def uniques  = []
        def uniquesedges = []
        nodes.each {
            uniques.add(it.idC1)
            uniques.add(it.idC2)
            def route = [it.idC1,it.idC2]
            uniquesedges.add(route)
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
        uniquesedges.each { arr -> 
            def route = JsonOutput.toJson([from: mapn.get(arr[0]), to: mapn.get(arr[1])] )
            ejson.add(route)
        }
       
        
        return [JsonOutput.toJson(djson),JsonOutput.toJson(ejson)]
    }
    def view(Long id){
        def component = componentService.get(id)
        def nodes = getNodes(id)[0]
        def edges = getNodes(id)[1]
        render(view:'view',model:[component:component , nodes: nodes, edges: edges])
    }
    def newComponent(){
        def list = componentService.list() ///Component.list()
        // here the component is created
        def name = params.name
        def url = params.url
        def port = params.port
        def dname = params.discoverName
        def squad = params.idSquad
        def token = params.token
        def seed = params.seed
        def gitlaburl = params.giturl
        if (!gitlaburl.isEmpty()){
            def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad,gitlab: gitlaburl)
            service.save()
        }else{
            if( seed == "XX"){
                 def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad,gitlab: gitlaburl)
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
                def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad,gitlab: gitlink)
                service.save()    
                }
            
        }
        def mensaje = "Component  ${name} created"
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
}
