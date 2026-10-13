package out.production;

public class Processador {
	public static void CircularShifting(Imatge ImgInput, Imatge ImgOutput, int incr_x, int incr_y) {
        assert ImgInput.getNFiles() <= ImgOutput.getNFiles() : "Massa files a l'entrada";
        assert ImgInput.getNCols() <= ImgOutput.getNCols() : "Massa columnes a l'entrada";

        for (int f = 0; f < ImgInput.getNFiles(); f++) {
            for (int c = 0; c < ImgInput.getNCols(); c++) {
                
                float valor = ImgInput.getValue(f, c);
                
                int nova_f = (f + incr_y) % ImgOutput.getNFiles();
                int nova_c = (c + incr_x) % ImgOutput.getNCols();
                
                ImgOutput.setValue(nova_f, nova_c, valor);
            }
        }
    }
}
