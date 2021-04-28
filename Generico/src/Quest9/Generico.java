package Quest9;


import java.util.Arrays;

public class Generico {
    String[] Prod = {"10011111","11000000","01100000","00101100",
            "10100010","11011010","00111011","00000111"};

    double[] sec = new double[8];
    int[] aux = new int[8];
    String[] auxBi = new String[8];

    public String paraBinario(int numero){
        byte b = (byte) numero;
        String s;
        if (b < 0) {
            s = Integer.toBinaryString (b);
            s = s.substring (s.length() - 8);
        } else {
            s = "0000000" + Integer.toBinaryString (b);
            s = s.substring (s.length() - 8);
        }
        return s;
    }

    public int paraDecimal(String bi){
        int potencia = 0;
        int decimal = 0;
        for(int i = bi.length() - 1; i>=0; i--){
            decimal += Math.pow(2,potencia) * Character.getNumericValue(bi.charAt(i));
            potencia ++;
        }
        return decimal;
    }

    public double Calculando(int x){
        return x*2-12*x+16;
    }

    public String[] Select(){
        int j=0;
        int top = 4;
        for(int i=0; i<Prod.length; i++){
            int axu1 = paraDecimal(Prod[i]);
            double axu2 = Calculando(axu1);
            sec[i] = axu2;
        }

        Arrays.sort(sec);

        for(int i = 0; i<4; i++){
            sec[i] = 0.0;
        }

        for(int i = 0; i<Prod.length; i++){
            sec[i] = sec[top];
            top++;
            if(top>7){
                break;
            }
        }

        for(int i = 4; i<8; i++){
            sec[i] = 0.0;
        }

        for(int i =0; i<8; i++){
            int axu1 = paraDecimal(Prod[i]);
            double axu2 = Calculando(axu1);
            if(sec[j] == axu2){
                aux[j] = axu1;
                j++;
                i=0;
            }
            if(j==3){
                for(int t = 0 ; t<8; t++){
                    axu1 = paraDecimal(Prod[t]);
                    axu2 = Calculando(axu1);
                    if(sec[3] == axu2){
                        aux[3] = axu1;
                    }
                }
            }
        }

        for(int i =0; i<4; i++){
            auxBi[i] = paraBinario(aux[i]);
        }

        for(int i=0; i<8; i++){
            Prod[i] = auxBi[i];
        }
        return  Prod;
    }

    public String[] getProd(){
        return Prod;
    }

    public String Cruzando(String x, String y){
        char[] x1 = x.toCharArray();
        char[] y1 = y.toCharArray();
        char[] filho = new char[8];

        for(int i = 0; i<2; i++){
            filho[i] = x1[i];
        }
        for(int i = 2; i<6; i++){
            filho[i] = y1[i];
        }
        for(int i = 6; i<8; i++){
            filho[i] = y1[i];
        }
        return String.valueOf(filho);
    }

}
