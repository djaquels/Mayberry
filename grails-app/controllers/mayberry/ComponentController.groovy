package mayberry
import groovyx.net.http.*
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
                seed = "18967563"
            break
        }
        [seed: seed ,framework: tech, squads: squads]
    }

    def view(Long id){
        def component = componentService.get(id)
        render(view:'view',model:[component:component])
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
        def mensaje = "Component  ${name} created"
        // forking the project fork?name=${name}&path=${name}
        //def http = new HTTPBuilder('http://gitlab.com/')
        StringBuilder result = new StringBuilder();
        def code = 0
        HttpURLConnection urlConnection;
        def urlParameters  = "?path=${name}&name=${name}";
        URL gitUrl = new URL("https://gitlab.com/api/v4/projects/${seed}/fork${urlParameters}");
        urlConnection = (HttpURLConnection) gitUrl.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("PRIVATE-TOKEN", token);
        InputStream ino = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(ino));
        String line;
        while ((line = reader.readLine()) != null) {
                result.append(line);
        }
        def texto = result.toString();
        code = urlConnection.getResponseCode();
        def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad)
        //example request 
        //curl --request POST   --header "PRIVATE-TOKEN:wg35TzG37zU7BbMkSXwb" 
        //"https://gitlab.com/api/v4/projects/18967563/fork?path=test&name=test"
        //service.save()
        render(view:'index',model:[components:list, mensaje: mensaje, result:texto, code:code])
    }
}
