import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Temas debca = new Temas("3", "barrio", "Azik", "1");

        JsonModel prueba = new JsonModel();

        prueba.addTemas(debca);

    }
}
