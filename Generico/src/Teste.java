import Quest7.Gererico;

public class Teste {
    public static void main(String[] args){
        Gererico genetico = new Gererico();
        String[] aux = genetico.getProd();
        int j = 0;
        int cont = 1;
        for(int i = 0; i < 8; i++){
            int axu1 = genetico.paraDecimais(aux[i]);
            double aux2 = genetico.Calculando(axu1);

            if(aux2 >= 0.950){
                System.out.println(axu1);
                System.out.println("A geração premiada é a de numero -> " + cont);
                break;
            }else{
                cont ++;
                String[] selecionar = genetico.Select();
                for(int x = 4; x<8; x++){
                    selecionar[x] = genetico.Cruzamento(selecionar[j],selecionar[j+1]);
                    selecionar[x+1] = genetico.Cruzamento(selecionar[j+1],selecionar[j]);
                    j++;
                    x++;
                }
                i=0;
            }
        }
    }
}