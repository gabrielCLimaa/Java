package netflux.main;

import netflux.entitys.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NetFlux {

    public static void main(String[] args) {
        ArrayList<Administrador> administradores = new ArrayList<>();
        ArrayList<Conteudo> conteudos = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Filme batman = new Filme("BATMAN", "2021", "PORTUGUES", "AÇÃO", 192.0);
        Filme superman = new Filme("SUPERMAN", "2021", "PORTUGUES", "AÇÃO", 122.0);
        Serie got = new Serie("GOT", "2021", "PORTUGUES", "MEDIEVAL", 2);
        Serie doctorwho = new Serie("DOCTOR", "2021", "PORTUGUES", "TRAVEL", 2);

        Episodio comeco = new Episodio("Time and all", 99.00);
        doctorwho.addEp(comeco);
        Episodio tempo = new Episodio("Time travel", 99.00);
        doctorwho.addEp(tempo);
        Episodio prologo = new Episodio("O inicio", 99.00);
        got.addEp(prologo);
        Episodio inicio = new Episodio("The winter is coming", 99.00);
        got.addEp(inicio);

        conteudos.add(batman);
        conteudos.add(superman);
        conteudos.add(got);
        conteudos.add(doctorwho);

        menuInicial(usuarios, administradores, conteudos);
    }

    static void menuInicial(ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        System.out.println("SEJA BEM VINDO AO NETFLUX");
        System.out.println("-------------------------------------------------");
        System.out.println("ONDE OS MELHORES FILMES E SERIES O AGUARDAM!!");
        System.out.println("PLANOS DE 30 , 50 E 90 REAIS MENSAIS");
        System.out.println("1) para logar");
        System.out.println("2) para se registrar como cliente");
        System.out.println("3) para se registrar como adm");
        System.out.println("0) para sair");
        System.out.println("-------------------------------------------------");
        Scanner in = new Scanner(System.in);
        while (true) {
            int op = in.nextInt();
            switch (op) {
                case 0 -> System.exit(0);
                case 1 -> menuLogin(usuarios, administradores, conteudos);
                case 2 -> {
                    Usuario usuario = menuUsuario(usuarios, administradores, conteudos);
                    timeLine(usuario, usuarios, administradores, conteudos);
                }
                case 3 -> {
                    Administrador adm = menuAdm(usuarios, administradores, conteudos);
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                }
            }
        }
    }

    static Usuario menuUsuario(ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        System.out.println("Por favor insira o seu nome!!");
        String nome = in.nextLine();
        System.out.println("Por favor insira o seu email!!");
        String email = in.nextLine();
        System.out.println("Por favor informe uma senha!!");
        String senha = in.nextLine();
        System.out.println("Por favor informe seu plano!!\r\n");
        int mensalidade = in.nextInt();

        Usuario novoUsuario = new Usuario(nome, email, senha, mensalidade);

        if (autenticadorUser(new Usuario(nome, email, senha, mensalidade), usuarios)) {
            usuarios.add(novoUsuario);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Usuario cadastrado com sucesso!!");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n");
            System.out.println("\r\n");
            return novoUsuario;

        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Houve um erro ao cadastrar usuario, por favor tente novamente!!");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n");
            menuInicial(usuarios, administradores, conteudos);
            return null;
        }
    }

    static void timeLine(Usuario user, ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        System.out.println("\r\n");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("BEM VINDO " + user.getNome().toUpperCase() + " A SUA TIMELINE, ONDE VOCE PODE ASSISTIR SEUS FILMES E SERIES!");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("0) PARA SAIR");
        System.out.println("1) PARA LISTAR FILMES E SERIES");
        System.out.println("2) PARA MUDAR DE PLANO");
        System.out.println("3) PARA ALTERAR NOME");
        System.out.println("4) PARA ALTERAR EMAIL");
        System.out.println("5) PARA ALTERAR SENHA");
        System.out.println("6) PARA EXCLUIR CONTA");

        int op = in.nextInt();
        switch (op) {
            case 0 -> System.exit(0);
            case 1 -> {
                int id = 0;
                for (Conteudo conteudo : conteudos) {
                    if (conteudo.getClass().equals(Filme.class)) {
                        Filme filme = (Filme) conteudo;
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("ID: " + id + " " + filme.showDescription());
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        id++;
                    } else {
                        Serie serie = (Serie) conteudo;
                        ArrayList<Episodio> episodios = serie.getListaEp();
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println("ID: " + id + " " + serie.showDescription());
                        System.out.println("Episodios: ");
                        int idEpisodio = 0;
                        for (Episodio episodio : episodios) {
                            System.out.println("ID episodio: " + idEpisodio + " " + episodio.toString());
                            idEpisodio++;
                        }
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        id++;
                    }
                }
                System.out.println("\r\n");
                System.out.println("---------------------------------------------------");
                System.out.println("1) PARA ASSISTIR FILME OU SERIE,(INFORMAR O ID)");
                System.out.println("2) PARA EFETUAR LOGOFF");
                System.out.println("0) PARA SAIR");
                System.out.println("---------------------------------------------------");
                System.out.println("!! O ID SE ENCONTRA NA FRENTE DE CADA ITEM!!");
                System.out.println("\r\n");
                int escolha = in.nextInt();
                switch (escolha) {
                    case 1 -> {
                        System.out.println("ID: ");
                        int idConteudo = in.nextInt();
                        midiaPlayer(idConteudo, user, usuarios, administradores, conteudos);
                    }
                    case 2 -> menuInicial(usuarios, administradores, conteudos);
                    case 0 -> System.exit(0);
                    default -> {
                        System.out.println("Opção inexistente!");
                        timeLine(user, usuarios, administradores, conteudos);
                    }
                }
            }
            case 2 -> {
                System.out.println("Informe qual plano deseja: 30, 50 ou 90");
                System.out.println("Lembrete: O plano deve ser diferente do atual");
                int novoPlano = in.nextInt();
                if (user.getMensalidade() == novoPlano || (!(novoPlano == 30 || novoPlano == 50 || novoPlano == 90))) {
                    System.out.println("Invalido");
                    timeLine(user, usuarios, administradores, conteudos);
                } else {
                    user.setMensalidade(novoPlano);
                    System.out.println("Mensalidade atualizada com sucesso!!!");
                    timeLine(user, usuarios, administradores, conteudos);
                }
            }
            case 3 -> {
                in.nextLine();
                System.out.println("Informe o novo nome");
                String novoNome = in.nextLine();
                if (novoNome.equals("") || novoNome == null) {
                    System.out.println("Invalido");
                    timeLine(user, usuarios, administradores, conteudos);
                } else {
                    user.setNome(novoNome);
                    System.out.println("Nome atualizado com sucesso!!!");
                    timeLine(user, usuarios, administradores, conteudos);
                }
            }
            case 4 -> {
                in.nextLine();
                System.out.println("Informe o novo email");
                String novoEmail = in.nextLine();
                if (novoEmail.equals("") || novoEmail == null) {
                    System.out.println("Invalido");
                    timeLine(user, usuarios, administradores, conteudos);
                } else {
                    user.setEmail(novoEmail);
                    System.out.println("Email atualizado com sucesso!!!");
                    timeLine(user, usuarios, administradores, conteudos);
                }
            }
            case 5 -> {
                in.nextLine();
                System.out.println("Informe a nova senha");
                String novaSenha = in.nextLine();
                if (novaSenha.equals("") || novaSenha == null) {
                    System.out.println("Invalido");
                    timeLine(user, usuarios, administradores, conteudos);
                } else {
                    user.setSenha(novaSenha);
                    System.out.println("Senha atualizada com sucesso!!!");
                    timeLine(user, usuarios, administradores, conteudos);
                }
            }
            case 6 -> usuarios.parallelStream().forEach(obj -> {
                if (obj.getEmail().equals(user.getEmail())) {
                    System.out.println("Operação realizada com sucesso!!");
                    usuarios.remove(obj);
                }
                menuInicial(usuarios, administradores, conteudos);
            });
            default -> {
                System.out.println("Opção inexistente!");
                timeLine(user, usuarios, administradores, conteudos);
            }
        }
    }

    static void timeLineAdm(Administrador adm, ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        System.out.println("\r\n");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("BEM VINDO " + adm.getNome().toUpperCase());
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("1) PARA INSERIR NOVO FILME");
        System.out.println("2) PARA INSERIR NOVA SERIE");
        System.out.println("3) PARA LISTAR FILMES E SERIES");
        System.out.println("4) PARA EXCLUIR FILME OU SERIE, (INFORMAR ID)");
        System.out.println("5) PARA EFETUAR LOGOFF");
        System.out.println("6) PARA EXCLUIR EPISODIO, (INFORMAR SERIE)");
        System.out.println("7) PARA ALTERAR NOME");
        System.out.println("8) PARA ALTERAR EMAIL");
        System.out.println("9) PARA ALTERAR SENHA");
        System.out.println("10) PARA EXCLUIR CONTA");
        System.out.println("11) PARA EDITAR SERIE");
        System.out.println("12) PARA EDITAR FILME");
        System.out.println("13) PARA LISTAR USUARIOS");
        System.out.println("14) PARA LISTAR ADM'S");
        System.out.println("0) PARA SAIR");
        System.out.println("---------------------------------------------------");
        System.out.println("\r\n");

        int op = in.nextInt();
        switch (op) {
            case 1 -> inserirFilme(adm, usuarios, administradores, conteudos);
            case 2 -> inserirSerie(adm, usuarios, administradores, conteudos);
            case 3 -> {
                int idConteudo = 0;
                for (Conteudo conteudo : conteudos) {
                    if (conteudo.getClass().equals(Filme.class)) {
                        Filme filme = (Filme) conteudo;
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("ID: " + idConteudo + " " + filme.showDescription());
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        idConteudo++;
                    } else {
                        Serie serie = (Serie) conteudo;
                        ArrayList<Episodio> episodios = serie.getListaEp();
                        System.out.println("-------------------------------------------------------------------------------------------------------------");
                        System.out.println("ID: " + idConteudo + " " + serie.showDescription());
                        System.out.println("Episodios: ");
                        int idEpisodio = 0;
                        for (Episodio episodio : episodios) {
                            System.out.println("ID episodio: " + idEpisodio + " " + episodio.toString());
                            idEpisodio++;
                        }
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        idConteudo++;
                    }
                }
                timeLineAdm(adm, usuarios, administradores, conteudos);
            }
            case 4 -> {
                System.out.println("ID: ");
                int id = in.nextInt();
                Conteudo retorno = conteudos.get(id);
                if (retorno.getTitulo().equals("")) {
                    System.out.println("Conteudo não encontrado");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                } else {
                    conteudos.remove(retorno);
                    System.out.println("Conteudo removido com exito!!!");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                }
            }
            case 5 -> menuInicial(usuarios, administradores, conteudos);
            case 6 -> {
                in.nextLine();
                System.out.println("Informe o nome da serie");
                String nomeSerie = in.nextLine();
                conteudos.forEach(obj -> {
                    if (obj.getTitulo().equalsIgnoreCase(nomeSerie)) {
                        System.out.println("Informe o id do episodio");
                        int idEpisodio = in.nextInt();
                        Serie serie = (Serie) obj;
                        ArrayList<Episodio> episodios = serie.getListaEp();
                        episodios.remove(idEpisodio);
                        serie.setNumeroEpisodios(serie.getNumeroEpisodios() - 1);
                        System.out.println("Removido com sucesso");
                        timeLineAdm(adm, usuarios, administradores, conteudos);
                    }
                });
                System.out.println("Serie não encontrada");
                timeLineAdm(adm, usuarios, administradores, conteudos);
            }
            case 7 -> {
                in.nextLine();
                System.out.println("Informe o novo nome");
                String novoNomeAdm = in.nextLine();
                if (novoNomeAdm.equals("") || novoNomeAdm == null) {
                    System.out.println("Invalido");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                } else {
                    adm.setNome(novoNomeAdm);
                    System.out.println("Nome atualizado com sucesso!!!");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                }
            }
            case 8 -> {
                in.nextLine();
                System.out.println("Informe o novo email");
                String novoEmailAdm = in.nextLine();
                if (novoEmailAdm.equals("") || novoEmailAdm == null) {
                    System.out.println("Invalido");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                } else {
                    adm.setEmail(novoEmailAdm);
                    System.out.println("Email atualizado com sucesso!!!");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                }
            }
            case 9 -> {
                in.nextLine();
                System.out.println("Informe a nova senha");
                String novaSenhaAdm = in.nextLine();
                if (novaSenhaAdm.equals("") || novaSenhaAdm == null) {
                    System.out.println("Invalido");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                } else {
                    adm.setSenha(novaSenhaAdm);
                    System.out.println("Senha atualizada com sucesso!!!");
                    timeLineAdm(adm, usuarios, administradores, conteudos);
                }
            }
            case 10 -> administradores.parallelStream().forEach(obj -> {
                if (obj.getEmail().equals(adm.getEmail())) {
                    System.out.println("Operação realizada com sucesso!!");
                    administradores.remove(obj);
                }
                menuInicial(usuarios, administradores, conteudos);
            });
            case 11 -> {
                in.nextLine();
                System.out.println("Informe o nome da serie);");
                String nomeEditSerie = in.nextLine();
                conteudos.forEach(serie -> {
                    if (serie.getTitulo().equalsIgnoreCase(nomeEditSerie) && serie.getClass().equals(Serie.class)) {
                        System.out.println("1) Editar nome");
                        System.out.println("2) Edita data de lançamento");
                        System.out.println("3) Editar linguagem");
                        System.out.println("4) Editar genero");
                        System.out.println("5) Editar episodio (Informar id do episodio)");
                        int editSerie = in.nextInt();
                        switch (editSerie) {
                            case 1 -> {
                                in.nextLine();
                                System.out.println("Informe o nome");
                                String novoNome = in.nextLine();
                                serie.setTitulo(novoNome);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 2 -> {
                                in.nextLine();
                                System.out.println("Informe a data");
                                String novaData = in.nextLine();
                                serie.setDataLancamento(novaData);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 3 -> {
                                in.nextLine();
                                System.out.println("Informe a linguagem");
                                String novaLinguagem = in.nextLine();
                                serie.setLinguagem(novaLinguagem);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 4 -> {
                                in.nextLine();
                                System.out.println("Informe o genero");
                                String novoGenero = in.nextLine();
                                serie.setGenero(novoGenero);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 5 -> {
                                in.nextLine();
                                System.out.println("Informe o id do episodio");
                                int idEditEpisodio = in.nextInt();
                                Serie serieEdit = (Serie) serie;
                                ArrayList<Episodio> episodiosEdit = serieEdit.getListaEp();
                                Episodio editedEpisodio = episodiosEdit.get(idEditEpisodio);
                                if (editedEpisodio.getTituloEpisodio().equals("")) {
                                    System.out.println("Episodio não encontrado");
                                    timeLineAdm(adm, usuarios, administradores, conteudos);
                                } else {
                                    in.nextLine();
                                    System.out.println("1) Para para editar titulo do episodio");
                                    System.out.println("2) Para editar duração do episodio");
                                    int episodiOP = in.nextInt();
                                    switch (episodiOP) {
                                        case 1 -> {
                                            in.nextLine();
                                            System.out.println("Informe o novo titulo");
                                            String novoTitulo = in.nextLine();
                                            editedEpisodio.setTituloEpisodio(novoTitulo);
                                            timeLineAdm(adm, usuarios, administradores, conteudos);
                                        }
                                        case 2 -> {
                                            in.nextLine();
                                            System.out.println("Informe a nova duração");
                                            double novaDuracao = in.nextDouble();
                                            editedEpisodio.setDuracao(novaDuracao);
                                            timeLineAdm(adm, usuarios, administradores, conteudos);
                                        }
                                        default -> {
                                            System.out.println("Opção invalida");
                                            timeLineAdm(adm, usuarios, administradores, conteudos);
                                        }
                                    }
                                }
                            }
                            default -> {
                                System.out.println("Opção invalida");
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                        }
                    }
                });
                System.out.println("Serie não encontrada");
                timeLineAdm(adm, usuarios, administradores, conteudos);
            }
            case 12 -> {
                in.nextLine();
                System.out.println("Informe o nome do filme);");
                String nomeEditFilme = in.nextLine();
                conteudos.forEach(filme -> {
                    if (filme.getTitulo().equalsIgnoreCase(nomeEditFilme) && filme.getClass().equals(Filme.class)) {
                        System.out.println("1) Editar nome");
                        System.out.println("2) Edita data de lançamento");
                        System.out.println("3) Editar linguagem");
                        System.out.println("4) Editar genero");
                        System.out.println("5) Editar duração");
                        int editFilme = in.nextInt();
                        switch (editFilme) {
                            case 1 -> {
                                in.nextLine();
                                System.out.println("Informe o nome");
                                String novoNome = in.nextLine();
                                filme.setTitulo(novoNome);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 2 -> {
                                in.nextLine();
                                System.out.println("Informe a data");
                                String novaData = in.nextLine();
                                filme.setDataLancamento(novaData);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 3 -> {
                                in.nextLine();
                                System.out.println("Informe a linguagem");
                                String novaLinguagem = in.nextLine();
                                filme.setLinguagem(novaLinguagem);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 4 -> {
                                in.nextLine();
                                System.out.println("Informe o genero");
                                String novoGenero = in.nextLine();
                                filme.setGenero(novoGenero);
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            case 5 -> {
                                in.nextLine();
                                System.out.println("Informe a duração");
                                String novaDuracaoFilme = in.nextLine();
                                Filme editedFilme = (Filme) filme;
                                editedFilme.setDuracao(Double.parseDouble(novaDuracaoFilme));
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                            default -> {
                                System.out.println("Opção invalida");
                                timeLineAdm(adm, usuarios, administradores, conteudos);
                            }
                        }
                    }
                });
                System.out.println("Filme não encontrado");
                timeLineAdm(adm, usuarios, administradores, conteudos);
            }

            case 13 -> {
                for(Pessoa pessoa : usuarios) {
                    if(pessoa.getClass().equals(Usuario.class)) {
                        Usuario usuario = (Usuario) pessoa;
                        System.out.println(usuario.showInformation());
                    }
                }
                timeLineAdm(adm, usuarios, administradores, conteudos);
            }

            case 14 -> {
                for(Pessoa pessoa : administradores) {
                    if(pessoa.getClass().equals(Administrador.class)) {
                        Administrador administrador = (Administrador) pessoa;
                        System.out.println(administrador.showInformation());
                    }
                }
                timeLineAdm(adm, usuarios, administradores, conteudos);
            }
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Opção invalida");
                timeLineAdm(adm, usuarios, administradores, conteudos);
            }
        }

    }

    static void menuLogin(ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        System.out.println("!!!LOGIN!!!");
        System.out.println("Informe o tipo de usuario!!!");
        System.out.println("1) PARA CLIENTE, 2) PARA FUNCIONARIO");
        String tipoUsuario = in.nextLine();
        System.out.println("Informe seu email!");
        String email = in.nextLine();
        System.out.println("Informe sua senha!");
        String senha = in.nextLine();

        if (tipoUsuario.equals("1")) {
            for (Usuario user : usuarios) {
                if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                    timeLine(user, usuarios, administradores, conteudos);
                } else {
                    System.out.println("Usuario inexistente, retornando ao menu incial.");
                    menuInicial(usuarios, administradores, conteudos);
                }
            }
        } else if (tipoUsuario.equals("2")) {
            for (Administrador adm : administradores) {
                if (adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
                    //
                    timeLineAdm(adm, usuarios, administradores, conteudos);

                } else {
                    System.out.println("Funcionario inexistente, retornando ao menu incial.");
                    menuInicial(usuarios, administradores, conteudos);
                }
            }
        } else {
            System.out.println("Houve algum erro, por favor tente novamente!");
            menuLogin(usuarios, administradores, conteudos);
        }

    }

    static Administrador menuAdm(ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        System.out.println("Por favor insira o seu nome!!");
        String nome = in.nextLine();
        System.out.println("Por favor insira o seu email!!");
        String email = in.nextLine();
        System.out.println("Por favor informe uma senha!!");
        String senha = in.nextLine();

        Administrador adm = new Administrador(nome, email, senha);

        if (autenticadorAdm(new Administrador(nome, email, senha), administradores)) {
            administradores.add(adm);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Administrador cadastrado com sucesso!!");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n");
            System.out.println("\r\n");
            return adm;

        } else {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Houve um erro ao cadastrar funcionario, por favor tente novamente!!");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n");
            menuInicial(usuarios, administradores, conteudos);
            return null;
        }
    }

    static boolean autenticadorAdm(Pessoa objeto, ArrayList<Administrador> lista) {
        for (Pessoa adm : lista) {
            if (adm.getEmail().equals(objeto.getEmail())) {
                return false;
            }
        }
        return true;
    }

    static boolean autenticadorUser(Pessoa objeto, ArrayList<Usuario> lista) {
        Usuario usuario = (Usuario) objeto;
        if (!(usuario.getMensalidade() == 30 || usuario.getMensalidade() == 50 || usuario.getMensalidade() == 90)) {
            return false;
        }

        for (Pessoa user : lista) {
            if (user.getEmail().equals(objeto.getEmail())) {
                return false;
            }
        }
        return true;
    }

    static void midiaPlayer(int idConteudo, Usuario user, ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        Conteudo filmeOuSerie = conteudos.get(idConteudo);
        MediaPlayer m1 = new MediaPlayer(filmeOuSerie);

        if (filmeOuSerie.getClass().equals(Filme.class)) {
            System.out.println("\r\n");
            System.out.println("---------------------------------------------------");
            System.out.println("1) Para iniciar exibição");
            System.out.println("2) Para parar exibição");
            System.out.println("3) Para voltar ao menu anterior");
            System.out.println("0) Para Sair");
            System.out.println("---------------------------------------------------");
            System.out.println("\r\n");

            int op = in.nextInt();
            switch (op) {
                case 0 -> System.exit(0);
                case 1 -> {
                    m1.Play();
                    System.out.println("\r\n");
                    midiaPlayer(idConteudo, user, usuarios, administradores, conteudos);
                }
                case 2 -> {
                    m1.StopPlaying();
                    System.out.println("\r\n");
                    midiaPlayer(idConteudo, user, usuarios, administradores, conteudos);
                }
                case 3 -> timeLine(user, usuarios, administradores, conteudos);
            }

        } else {
            System.out.println("\r\n");
            System.out.println("---------------------------------------------------");
            System.out.println("1) Para parar listar o titulo dos episodios!");
            System.out.println("2) Para iniciar exibição, infome o ID do Episodio!");
            System.out.println("3) Para parar exibição!");
            System.out.println("4) Para voltar ao menu anterior!");
            System.out.println("0) Para Sair!");
            System.out.println("---------------------------------------------------");
            System.out.println("\r\n");

            int op = in.nextInt();
            switch (op) {
                case 0 -> System.exit(0);
                case 2 -> {
                    System.out.println("Informe o numero do Episodio");
                    int episodio = in.nextInt();
                    m1.PlaySerie(episodio);
                    midiaPlayer(idConteudo, user, usuarios, administradores, conteudos);
                }
                case 3 -> {
                    m1.StopPlayingSerie(m1.getEpisodioExibindo());
                    System.out.println("\r\n");
                    midiaPlayer(idConteudo, user, usuarios, administradores, conteudos);
                }
                case 4 -> timeLine(user, usuarios, administradores, conteudos);
                case 1 -> {
                    Serie serie = (Serie) conteudos.get(idConteudo);
                    serie.printEps();
                    midiaPlayer(idConteudo, user, usuarios, administradores, conteudos);
                }
            }
        }
    }

    static void inserirSerie(Administrador adm, ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        System.out.println("\r\n");
        System.out.println("Informe o nome da serie!");
        String nomeSerie = in.nextLine();
        System.out.println("Informe a data de lançamento!");
        String dataLancamento = in.nextLine();
        System.out.println("Informe a linguagem!");
        String linguagem = in.nextLine();
        System.out.println("Informe o genero!");
        String genero = in.nextLine();
        System.out.println("Informe o numero de episodios");
        int numeroEp = in.nextInt();

        Serie nova = new Serie(nomeSerie, dataLancamento, linguagem, genero, numeroEp);

        conteudos.add(nova);

        System.out.println("\r\n");
        System.out.println("--------------------------------------------------------");
        System.out.println("Agora insira os episodios!!!");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < nova.getNumeroEpisodios(); i++) {
            in.nextLine();
            System.out.println("Informe o titulo do episodio: " + (i + 1));
            String tituloEp = in.nextLine();

            System.out.println("Informe a duração do episodio:  " + (i + 1));
            String d = in.nextLine();
            double duracao = Double.parseDouble(d);
            Episodio episodio = new Episodio(tituloEp, duracao);
            nova.addEp(episodio);

            System.out.println("\r\n");
            System.out.println("------------------------------");
            System.out.println("Episodio inserido com sucesso");
            System.out.println("------------------------------");
            System.out.println("PRESSIONE ENTER");
        }

        System.out.println("\r\n");
        System.out.println("--------------------------------------------------------");
        System.out.println("Serie inserida com sucesso, retornando ao menu anterior!");
        System.out.println("--------------------------------------------------------");
        timeLineAdm(adm, usuarios, administradores, conteudos);

    }

    static void inserirFilme(Administrador adm, ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Conteudo> conteudos) {
        Scanner in = new Scanner(System.in);
        System.out.println("\r\n");
        System.out.println("Informe o nome do filme!");
        String nomeFilme = in.nextLine();
        System.out.println("Informe a data de lançamento!");
        String dataLancamento = in.nextLine();
        System.out.println("Informe a linguagem!");
        String linguagem = in.nextLine();
        System.out.println("Informe o genero!");
        String genero = in.nextLine();
        System.out.println("Informe a duração");
        String duracao1 = in.nextLine();
        double duracao = Double.parseDouble(duracao1);

        Filme nova = new Filme(nomeFilme, dataLancamento, linguagem, genero, duracao);

        conteudos.add(nova);

        System.out.println("\r\n");
        System.out.println("--------------------------------------------------------");
        System.out.println("Filme inserido com sucesso, retornando ao menu anterior!");
        System.out.println("--------------------------------------------------------");
        timeLineAdm(adm, usuarios, administradores, conteudos);
    }
}
