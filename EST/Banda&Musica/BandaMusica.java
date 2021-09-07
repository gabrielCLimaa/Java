/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EST2;

import EST2.Exceptions.BandaExceptions;
import EST2.Exceptions.InvalidEntryException;
import EST2.Exceptions.MusicaExceptions;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author G
 */
public class BandaMusica {

    public static void main(String[] args) {
        ArrayList<Musica> musicas = new ArrayList<>();
        ArrayList<Banda> bandas = new ArrayList<>();
        menu(bandas, musicas);
    }

    public static void menu(ArrayList<Banda> bandas, ArrayList<Musica> musicas) {
        System.out.println("-------------------------------------------------");
        System.out.println(" - - BEM VINDO - - ");
        System.out.println("1)  adicionar banda");
        System.out.println("2)  adicionar musica");
        System.out.println("3)  editar musica");
        System.out.println("4)  editar banda");
        System.out.println("5)  listar musicas");
        System.out.println("6)  listar bandas");
        System.out.println("7)  listar musicas de uma banda");
        System.out.println("0)  SAIR");
        System.out.println("-------------------------------------------------");
        Scanner in = new Scanner(System.in);
        while (true) {
            int op = in.nextInt();
            switch (op) {
                case 0:
                    System.exit(0);
                    break;

                case 1: 
                         try {
                    in.nextLine();
                    System.out.println("Infome o nome da banda");
                    String nomeBanda = in.nextLine();
                    addBanda(nomeBanda, bandas);
                    menu(bandas, musicas);
                } catch (InvalidEntryException err) {
                    System.out.println(err.getMessage());
                }
                break;
                case 2:
                         try {
                    in.nextLine();
                    System.out.println("Infome o nome da musica");
                    String nomeMusica = in.nextLine();
                    addMusica(nomeMusica, musicas);
                    menu(bandas, musicas);
                } catch (InvalidEntryException err) {
                    System.out.println(err.getMessage());
                }
                break;
                case 3:
                    try {
                        in.nextLine();
                        System.out.println("Infome o id  da musica que deseja editar, \n se não souber liste!!");
                        int idMusica = in.nextInt();
                        Musica musica = musicas.get(idMusica);
                        if (musica.getNome().equals("")) {
                            throw new MusicaExceptions("O nome da musica não pode ser null");
                        }
                        if(!editMusica(musica,bandas))
                            throw new MusicaExceptions("Houve um erro tente novamente!!");
                        menu(bandas, musicas);
                    } catch(MusicaExceptions err) {
                        System.out.println(err.getMessage());
                    }
                    break;
                case 4:
                    try {
                        in.nextLine();
                        System.out.println("Infome o id  da banda que deseja editar, \n se não souber liste!!");
                        int idBanda = in.nextInt();
                        Banda banda = bandas.get(idBanda);
                        if (banda.getNome().equals("")) {
                            throw new BandaExceptions("O nome da banda não pode ser null");
                        }
                        if(!editBanda(banda,musicas,bandas))
                            throw new MusicaExceptions("Houve um erro tente novamente!!");
                        menu(bandas, musicas);
                    } catch(MusicaExceptions err) {
                        System.out.println(err.getMessage());
                    }
                    break;
                case 5:
                    in.nextLine();
                    listMusicas(musicas);
                    System.out.println("\r\n");
                    menu(bandas, musicas);
                    break;
                case 6:
                    in.nextLine();
                    listBandas(bandas);
                    System.out.println("\r\n");
                    menu(bandas, musicas);
                    break;
                case 7:
                    try {
                        in.nextLine();
                        System.out.println("Infome o nome da banda que deseja ver as musicas");
                        String nomeBandaMusicas = in.nextLine();
                        for (Banda bandaMusicas : bandas) {
                            if (bandaMusicas.getNome().equalsIgnoreCase(nomeBandaMusicas)) {
                                if (bandaMusicas.getNumeroDeMusicas() == 0) {
                                    throw new BandaExceptions("Banda não contem musicas");
                                }
                                listMusicaByBanda(bandaMusicas);
                                System.out.println("\r\n");
                                menu(bandas, musicas);
                            }
                        }
                        throw new BandaExceptions("Banda não encontrada");
                    } catch (BandaExceptions err) {
                    System.out.println(err.getMessage());
                }
                break;
                default:
                    System.out.println("Opção invalida!!");
                    menu(bandas, musicas);
                    break;
            }
        }
    }
    

    public static boolean addBanda(String nome, ArrayList<Banda> bandasGerais) throws InvalidEntryException {
        if (nome.equals("") || nome == null) {
            throw new InvalidEntryException("O nome não pode ser null");
        }
        Banda novaBanda = new Banda(nome);
        bandasGerais.add(novaBanda);
        return true;
    }

    public static boolean addMusica(String nome, ArrayList<Musica> musicasGerais) throws InvalidEntryException  {
        if (nome.equals("") || nome == null) {
            throw new InvalidEntryException("O nome não pode ser null");
        }
        Musica novaMusica = new Musica(nome);
        musicasGerais.add(novaMusica);
        return true;
    }

    public static boolean editMusica(Musica musica, ArrayList<Banda> bandasGerais) {
        Scanner in2 = new Scanner(System.in);
        System.out.println("1) para mudar nome");
        System.out.println("2) para mudar a banda");
        int op = in2.nextInt();
        switch (op) {
            case 1:
                in2.nextLine();
                System.out.println("Informe o nome");
                String novoNome = in2.nextLine();
                musica.setNome(novoNome);
                return true;
            case 2:
                in2.nextLine();
                System.out.println("Iforme o nome da banda");
                String nomeBanda = in2.nextLine();
                for (Banda banda : bandasGerais) {
                    if (banda.getNome().equals(nomeBanda)) {
                        musica.setBanda(banda);
                        for (Banda bandaIn : bandasGerais) {
                            if (bandaIn.getMusicasBanda().contains(musica)) {
                                bandaIn.removeMusica(musica);
                            }
                        }
                        banda.addMusica(musica);
                        return true;
                    }
                }
                return false;
            default:
                System.out.println("Operação invalida");
                return false;
        }
    }

    public static boolean editBanda(Banda banda, ArrayList<Musica> musicasGerais, ArrayList<Banda> bandasGerais) {
        Scanner in3 = new Scanner(System.in);
        System.out.println("1) para mudar nome");
        System.out.println("2) para adcionar musica");
        System.out.println("3) para remover musica");
        int op = in3.nextInt();
        switch (op) {
            case 1:
                in3.nextLine();
                System.out.println("Informe o nome");
                String novoNome = in3.nextLine();
                banda.setNome(novoNome);
                return true;
            case 2:
                in3.nextLine();
                System.out.println("Iforme o nome da musica");
                String nomeMusica = in3.nextLine();
                for (Musica musica : musicasGerais) {
                    if (musica.getNome().equals(nomeMusica)) {
                        musica.setBanda(banda);
                        for (Banda bandaIn : bandasGerais) {
                            if (bandaIn.getMusicasBanda().contains(musica)) {
                                bandaIn.removeMusica(musica);
                            }
                        }
                        banda.addMusica(musica);
                        return true;
                    }
                }
                return false;
            case 3:
                in3.nextLine();
                System.out.println("Informe o nome da musica");
                String removeNome = in3.nextLine();
                for (Musica musica : banda.getMusicasBanda()) {
                    if (musica.getNome().equals(removeNome)) {
                        banda.removeMusica(musica);
                        musica.setBanda(null);
                        return true;
                    }
                }
                return false;
            default:
                System.out.println("Operação invalida");
                return false;
        }
    }

    public static void listMusicas(ArrayList<Musica> musicas) {
        int i = 0;
        for (Musica musica : musicas) {
            System.out.println("ID: " + i + " " + musica.toString());
            i++;
        }
    }

    public static void listBandas(ArrayList<Banda> bandas) {
        int i = 0;
        for (Banda banda : bandas) {
            System.out.println("ID: " + i + " " + banda.toString());
            i++;
        }
    }

    public static void listMusicaByBanda(Banda banda) {
        ArrayList<Musica> musicas = banda.getMusicasBanda();
        musicas.forEach(musica -> System.out::println);
    }

}
