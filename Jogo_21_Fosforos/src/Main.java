import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static int fosforos = 21, retira;

    public static void main(String[] args) {
        int op = 1;

        while (op != 0) {
            System.out.println("Jogo dos 21 Fosforos");
            System.out.println("Retire 1, 2, 3 ou 4 fosforos.");
            System.out.println("O jogador que ficar com 1 fosforo perde.");
            System.out.println("Escolha o seu oponente:");
            System.out.println("1 - Outro jogador");
            System.out.println("2 - Máquina inteligente");
            System.out.println("3 - Máquina");
            System.out.println("0 - Sair");
            try {
                op = in.nextInt();

                switch (op) {
                    case 0:
                        break;
                    case 1:
                        Jogador();
                        break;
                    case 2:
                        MaquinaInt();
                        break;
                    case 3: Maquina();break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido, tente novamente");
                in.nextLine();
            }
        }
    }

    private static void Maquina() {
        in = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            System.out.println("Jogo contra máquina");
            System.out.println("Escolha o 1º a jogar:");
            System.out.println("1 - Jogador");
            System.out.println("2 - Máquina");
            System.out.println("0 - Voltar menu anterior");
            try {
                op = in.nextInt();
                
                switch (op){
                    case 0: break;
                    case 1: Jogador1(); break;
                    case 2: Maquina1();break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Valor inválido, tente novamente");
                in.nextLine();
            }
        }

    }

    private static void Maquina1() {
        //Maquina é a 1º a jogar
        while (fosforos >= 1) {
            int valor = rnd.nextInt(1, 5);
            while (fosforos-valor<=0){ //ENQUANTO O VALOR ALEATORIO FOR MAIOR QUE OS FOSFOROS EM JOGO
                valor = rnd.nextInt(1, 5);
            }
            System.out.println("A máquina retira " + valor);
            fosforos -= valor;
            if (fosforos == 1) {
                System.out.println("A máquina ganhou o jogo");
                fosforos = 21;
                return;
            }
            System.out.println("Jogador é a sua vez:");
            Jogo();
            if (fosforos == 1) {
                System.out.println("Parabens, ganhou o jogo");
                fosforos = 21;
                return;
            }
        }
    }

    private static void Jogador1() {
        //JOGADOR 1º A JOGAR
        while (fosforos >= 1) {
            System.out.println("Jogador é a sua vez:");
            Jogo();
            if (fosforos == 1) {
                System.out.println("Parabens, ganhou o jogo");
                fosforos = 21;
                return;
            }

            //VEZ DA MAQ JOGAR
            int valor = rnd.nextInt(1, 5); //GERA NUM ALEATORIO DE FOSFOROS A RETIRAR
            while (fosforos-valor<=0){ //ENQUANTO O VALOR ALEATORIO FOR MAIOR QUE OS FOSFOROS EM JOGO
                valor = rnd.nextInt(1, 5);
            }
            System.out.println("A máquina retira " + valor);
            fosforos -= valor;
            if (fosforos == 1) {
                System.out.println("A máquina ganhou o jogo");
                fosforos = 21;
                return;
            }

        }
    }

    private static void MaquinaInt() {
        in = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            System.out.println("Jogo contra máquina inteligente");
            System.out.println("Escolha o 1º a jogar:");
            System.out.println("1 - Jogador");
            System.out.println("2 - Máquina");
            System.out.println("0 - Voltar menu anterior");
            try {
                op = in.nextInt();

                switch (op) {
                    case 0:
                        break;
                    case 1:
                        Maquina2Jogar();
                        break;
                    case 2:
                        Maquina1Jogar();
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido, tente novamente");
                in.nextLine();
            }
        }
    }

    private static void Maquina1Jogar() {
        //Maquina é a 1º a jogar
        while (fosforos >= 1) {
            int valor = rnd.nextInt(1, 5);
            System.out.println("A máquina retira " + valor);
            fosforos -= valor;
            System.out.println("Jogador é a sua vez:");
            Jogo();
            if (fosforos == 1) {
                System.out.println("Parabens, ganhou o jogo");
                fosforos = 21;
                return;
            }

            if (valor + retira < 5) { //maquina passa a ter vantagem

                System.out.println("A maquina retira " + valor);
                Maquina2Jogar(); //passa para o metodo e a maquina vai ganhar
                return;//sai deste metodo para o menu
            } else if (valor + retira > 5) { //maquina passa a ter vantagem
                valor = 10 - (valor + retira);
                fosforos -= valor;
                System.out.println("A maquina retira " + valor);
                Maquina2Jogar();//passa para o metodo e a maquina vai ganhar
                return;//sai deste metodo para o menu
            } //SE NÃO ENTRAR EM NENHUMA É PQ O JOGADOR JOGOU BEM
            //MAQUINA JOGA NUMERO ALEATORIO
        }
    }

    private static void Maquina2Jogar() {
        //Jogador joga 1º

        while (fosforos >= 1) {
            System.out.println("Jogador é a sua vez.");
            Jogo();
          //MAQUINA TEM INTELIGENCIA, JOGADOR NUNCA GANHA

            //VEZ DA MAQUINA JOGAR
            int valor;
            valor = 5 - retira;
            System.out.println("A máquina retira " + valor);
            fosforos -= valor;
            if (fosforos == 1) {
                System.out.println("A máquina ganhou.");
                fosforos = 21;
                return;
            }
        }
    }

    private static void Jogador() {
        in = new Scanner(System.in);
        System.out.println("Jogador 1 introduza o seu nome:");
        String jogador1 = in.nextLine();
        System.out.println("Jogador 2 introduza o seu nome:");
        String jogador2 = in.nextLine();
        int vez = rnd.nextInt(1, 3);//Escolhe aleatóriamente qual é o 1º a jogar

        while (fosforos >= 1) {
            if (vez == 1) {//JOGADOR1 COMEÇA A JOGAR
                System.out.println(jogador1 + " É a sua vez de jogar");
                Jogo();
                if (fosforos == 1) { //VERIFICA SE O JOGO TERMINOU
                    System.out.println(jogador1 + " Parabens, ganhou o jogo");
                    System.out.println(jogador2 + " Perdeu o jogo.");
                    fosforos = 21; //RENICIALIZA O JOGO
                    return;
                } else { //PASSA A VEZ AO JOGADOR
                    System.out.println(jogador2 + " É a sua vez de jogar");
                    Jogo();
                    if (fosforos == 1) {
                        System.out.println(jogador2 + " Parabens, ganhou o jogo");
                        System.out.println(jogador1 + " Perdeu o jogo.");
                        fosforos = 21; //RENICIALIZA O JOGO
                        return;
                    }
                }
            } else { //JOGADOR2 COMEÇA A JOGAR
                System.out.println(jogador2 + " É a sua vez de jogar");
                Jogo();
                if (fosforos == 1) {
                    System.out.println(jogador2 + " Parabens, ganhou o jogo");
                    System.out.println(jogador1 + " Perdeu o jogo.");
                    fosforos = 21; //RENICIALIZA O JOGO
                    return;
                } else {
                    System.out.println(jogador1 + " É a sua vez de jogar");
                    Jogo();
                    if (fosforos == 1) {
                        System.out.println(jogador1 + " Parabens, ganhou o jogo");
                        System.out.println(jogador2 + " Perdeu o jogo.");
                        fosforos = 21; //RENICIALIZA O JOGO
                        return;
                    }
                }
            }
        }

    }

    private static void Jogo() {
        in = new Scanner(System.in);
        int op = 1;
        while (op != 0) {
            System.out.println("Estão " + fosforos + " fosforos em jogo, quantos retira?");
            System.out.println("(1, 2, 3 ou 4)");
            try {
                retira = in.nextInt();
                if (retira == 1 || retira == 2 || retira == 3 || retira == 4) {
                    if (fosforos - retira >= 1) {
                        fosforos = fosforos - retira;
                        return;
                    } else System.out.println("Está a retirar mais fosforos dos que estão em jogo. Tente novamente");

                } else System.out.println("Valor inválido, tente novamente");
            } catch (Exception e) {
                System.out.println("Valor inválido, tente novamente");
                in.nextLine();
            }

        }
    }
}