
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JsonModel implements DataManager {
    private Temas newTema;
    private Instrumental newInstrumental;

    ApiRequests encargadoPeticiones;
    private String SERVER_PATH, GET_TEMA, GET_INSTRUMENTAL, SET_TEMA, SET_CURSE; // Datos de la conexion

    public JsonModel() {
        char c;

        encargadoPeticiones = new ApiRequests();

        SERVER_PATH = "http://localhost:8888/PracticaBBDD/";
        GET_TEMA = "readTema.php";
        GET_INSTRUMENTAL = "readInstrumental.php";
        SET_TEMA = "writeTema.php";
        SET_CURSE = "writeInstrumental.php";

    }

    @Override
    public void addTemas(Temas tema) throws FileNotFoundException, IOException {

        try {
            JSONObject objJTemas = new JSONObject();
            JSONObject objPeticion = new JSONObject();

            objJTemas.put("ID", tema.getStr_mid());
            objJTemas.put("Nombre", tema.getStr_mname());
            objJTemas.put("Instrumental", tema.getStr_minstrumental());
            objJTemas.put("ID_Instrumental", tema.getStr_midinstrumental());

            objPeticion.put("peticion", "add");
            objPeticion.put("tema", objJTemas);

            String json = objPeticion.toJSONString();
            String url = SERVER_PATH + SET_TEMA;
            String response = encargadoPeticiones.postRequest(url, json);
            System.out.println(response);

        } catch (Exception e) {
            System.out.println(
                    "Excepcion desconocida.");
            // e.printStackTrace();
            System.out.println("Fin ejecución");
            System.exit(-1);
        }

    }

    @Override
    public void addInstrumentales(Instrumental instrumental) throws FileNotFoundException, IOException {
/*
        try {
            JSONObject objJCurse = new JSONObject();
            JSONObject objPeticion = new JSONObject();

            objJCurse.put("int_id", auxCurse.getInt_id());
            objJCurse.put("str_mname", auxCurse.getStr_mname());
            objJCurse.put("str_mfirst_characteristic", auxCurse.getStr_mfirst_characteristic());
            objJCurse.put("str_msecond_characteristic", auxCurse.getStr_msecond_characteristic());
            objJCurse.put("str_mthird_characteristic", auxCurse.getStr_mthird_characteristic());

            objPeticion.put("peticion", "add");
            objPeticion.put("curse", objJCurse);

            String json = objPeticion.toJSONString();
            String url = SERVER_PATH + SET_CURSE;
            String response = encargadoPeticiones.postRequest(url, json);
            System.out.print("Insert hecho");

        } catch (Exception e) {
            System.out.println(
                    "Excepcion desconocida.");
            // e.printStackTrace();
            System.out.println("Fin ejecución");
            System.exit(-1);
        }

     */

    }

    @Override
    public void showAllTemas() throws FileNotFoundException, IOException {

    }

    @Override
    public void showAllInstrumentales() throws FileNotFoundException, IOException {

    }

}


