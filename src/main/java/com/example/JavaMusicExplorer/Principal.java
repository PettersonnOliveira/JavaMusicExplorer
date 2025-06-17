package com.example.JavaMusicExplorer;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistaRepository repositorio;
    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 6) {
            var menu = """
                    Selecione uma opção:
                    1. Cadastrar Artistas
                    2. Cadastrar Músicas
                    3. Listar Músicas
                    4. Buscar Músicas por Artista
                    5. Buscar informações de um Artista
                    6. Sair
                    """;

            System.out.println(menu);
            System.out.print("Digite a opção: ");
            opcao = leitura.nextInt();


            switch (opcao) {
                case 1:
                    // Cadastrar Artistas
                    cadastrarArtista();
                    break;
                case 2:
                    // Cadastrar Músicas
                    CadastrarMusica();
                    break;
                case 3:
                    // Listar Músicas
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 6:
                    // Sair
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

    }

    private void pesquisarDadosDoArtista() {
        System.out.println("Pesquisar dados sobre qual artista? ");
        var nome = leitura.nextLine();
        var resposta = ConsultaChatGPT.obterInformacao(nome);
        System.out.println(resposta.trim());
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Buscar músicas de que artista?");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscarMusicasPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));

    }

    private void CadastrarMusica() {
        System.out.println("Cadastrar musica de que artista?");
        leitura.nextLine(); // Limpar o buffer do scanner
        String nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if ( artista.isPresent()) {
            System.out.println("Artista encontrado: " + artista.get().getNome());
            System.out.print("Digite o título da música: ");
            String nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado. Por favor, cadastre o artista primeiro.");
        }

    }

    private void cadastrarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Cadastro de Artista");
            System.out.print("Digite o nome do artista: ");
            leitura.nextLine(); // Limpar o buffer do scanner
            String nome = leitura.nextLine();
            System.out.print("Digite o tipo do artista (BANDA, SOLO, DUPLA): ");
            String tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }


    }
}