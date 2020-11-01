package grafos;

public class CaminosMinimos {
    // Método para determinar todos los caminos Floyd

    public String algoritmoFloyd(long[][] mAdy) {
        int vertices = mAdy.length;
        long matrizAdyacencia[][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String caminosAuxiliar[][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporall, temporal2, temporal3, temporal4, minimo;
        //Inicializando las matrices caminos y caminosAuxiliares.
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAuxiliar[i][j] = "";
            }
        }
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporall = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    //Emcontrando al minimo.
                    minimo = Math.min(temporall, temporal4);
                    if (temporall != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAuxiliar[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAuxiliar, caminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo;
                }
            }
        }
        //Agregando el camino a cadena
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";
        }
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De [" + (i + 1) + "--->" + (j + 1) + "] Irse Por... (" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irrse Por...(" + (i + 1) + ", " + caminos[i][j] + ", " + (j + 1) + ") \n";
                        }
                    }
                }
            }
        }
        return "La Matriz de Caminos Más Cortos Entre Los Diferentes Vértices es: \n " + cadena + "\nLos diferentes Caminos Más Cortos Entre Vertices son: \n" + caminitos;
    }
    
    
    public String caminosR(int i, int k, String [][] caminosAuxiliares, String caminoRecorrido){
        if(caminosAuxiliares [i][k].equals("")){
            return "";
        }else{
            //Recursividad 
            caminoRecorrido += caminosR(i,Integer.parseInt(caminosAuxiliares[i][k].toString()),caminosAuxiliares, caminoRecorrido)+(Integer.parseInt(caminosAuxiliares[i][k].toString())+ 1) + ", ";
            return caminoRecorrido;
        }
    }
    
    

}
