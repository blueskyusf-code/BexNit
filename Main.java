package com.bexnit;

import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Base64;
import java.io.InputStream;
import java.io.IOException;

public class Main {
    private static String name;
    private static int age;
    private static String nf;
    private static String va;
    private static String menu;
    private static String password;
    private static String developer;
    private static String idadeStr;
    private static String senhaToken;
    private static String passworddeveloper = "not";
    private static String mdev;
    private static double version = 1.0;
    private static String creators = "The Blu3sky";
    static {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
    }
    
private static void sfload() {
        Scanner reader = new Scanner(System.in);
            clear();
            System.out.println("SFload Interact");
            System.out.println("Digite /exit para sair");
            System.out.println("AVISO: SFload pode parecer um humano, mas ele é uma inteligência artificial.");
            System.out.println("Não compartilhe dados pessoais ou segredos. Não lidaremos com qualquer erro seu.");
            System.out.println("");
            while (true) {
                
            System.out.print("-> ");
            String message = reader.nextLine();
            
            if (message.equalsIgnoreCase("Acorde!")) {
                String[] resposta = {
                    "... ah oi",
                    "... por... oi...",
                    "... oi..."
                };
                Random rdm = new Random();
                int adpi = rdm.nextInt(resposta.length); 
                
                String mlp = resposta[adpi]; 
                
                System.out.println("\nSFload: " + mlp);
                sleep(3000);
            }
                else if (message.equalsIgnoreCase("Quer Café?")) {
                    String[] resposta = {
                    "... café?... quero sim...",
                    "... quero...",
                    "... café... quero..."
                };
                Random rdm = new Random();
                int adpi = rdm.nextInt(resposta.length); 
                
                String mlp = resposta[adpi]; 
                
                System.out.println("\nSFload: " + mlp);
                sleep(3000);
                System.out.println("* Ele pega o café e capota no sono *");
                sleep(3000);
                }
                else if (message.toLowerCase().contains("acorde d*sgraça")) {
                    String[] resposta = {
                    "... pare de gritar...😭",
                    "... 😭",
                    "... tá mas não precisa gritar comigo...😭"
                };
                Random rdm = new Random();
                int adpi = rdm.nextInt(resposta.length); 
                
                String mlp = resposta[adpi]; 
                
                System.out.println("\nSFload: " + mlp);
                sleep(3000);
                }
                else if (message.equalsIgnoreCase("Tudo bem?")) {
                String[] resposta = {
                    "... hm... sim",
                    "... sim...",
                    "... sim... sim..."
                };
                Random rdm = new Random();
                int adpi = rdm.nextInt(resposta.length); 
                
                String mlp = resposta[adpi]; 
                
                System.out.println("\nSFload: " + mlp);
                sleep(3000);
            }
                else if (message.equalsIgnoreCase("Vamos Conversar?")) {
                    System.out.println("SFload: C-Conversar? 👉👈");
                sleep(3000);
                System.out.println("* SFload se esconde atrás de um livro *");
                sleep(3000);
                }
                else if (message.equalsIgnoreCase("/exit")) {
                    System.out.println("Você saiu do SFload");
                System.out.println("Esta mensagem não será mostrada ao SFload");
                sleep(3000);
                break;
                }
                else if (message.equalsIgnoreCase("/clear")) {
                    System.out.println("Limpando tela...");
                sleep(3000);
                clear();
                }
                else if (message.equalsIgnoreCase("/jump")) {
                    System.out.println("Mensagem Pulada, SFload não vai responder até você digitar a próxima mensagem");
                }
                else {
                    System.out.println("SFload: ...");
                    sleep(3000);
                }
        }
    }

    
    private static void ipo(String ipo) {
        System.out.println(ipo);
    }
    
    private static void gds() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        senhaToken = Base64.getEncoder().encodeToString(bytes);
        passworddeveloper = gerarHash(senhaToken);
        System.out.println("Esta senha é pra desenvolvedor: " + senhaToken);
        save();
    }
    private static void developermenu() {
        Scanner reader = new Scanner(System.in);
        while (true) {
            clear();
        System.out.println("BexNit Developer");
        System.out.println("1. Piadas");
        System.out.println("2. Versão");
        System.out.println("3. Criadores");
            ipo("0. Sair");
        System.out.print("Selecione: ");
        mdev = reader.nextLine();
        if (mdev.equals("1")) {
            clear();
                String[] piadas = {
                    "O que a parede disse pra outra? eu não sei pq que a gente é fundido ;-;",
                    "O que o peixe foi fazer no mar? pra nadar",
                    "O que a argola disse pra outra? eu vou segurar aquela arvore",
                    "O que o lento disse pro rapido? ele disse, calma, eu não sou o flash",
                    "O que o nada disse pro tudo? tome nada, já que eu sou o nada",
                    "O que o preto disse pro branco? branco",
                    "O que o double disse pro int? números",
                    "O que o null disse pro infinite? nada",
                    "O que o sistema disse pro /dev/null? não me coma"
                };
                Random adp = new Random();
                int iwj = adp.nextInt(piadas.length);
                
                String rpi = piadas[iwj];
                
                System.out.println(rpi);
                sleep(6000);
        }
        else if (mdev.equals("2")) {
            clear();
            ipo("\nVersão: " + version);
            sleep(5000);
           }
            else if (mdev.equals("3")) {
                clear();
                ipo("Criadores: " + creators);
            sleep(5000);
            }
            else if (mdev.equals("0")) {
                System.exit(0);
            }
            else {
                clear();
                ipo("Opção invalida!");
                sleep(5000);
            }
        }
    }
        private static void sfloadverifycore() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pra confirmar que você não é kids responda:");
        System.out.print("Em que ano Pedro Álvares Cabral descobriu o Brasil? : ");
        
        String resposta = sc.nextLine().trim();
        
        if (resposta.contains("1500") || 
            resposta.equalsIgnoreCase("1500") || 
            resposta.contains("mil e quinhentos") || 
            resposta.contains("mil quinhentos")) {
            
            System.out.println("Resposta correta! Pode passar.");
            va = "Yes";
            sleep(800);
        } else {
            System.out.println("Errou feio. Tenta de novo quando aprender História do Brasil kkk");
            va = "No";
            sleep(1500);
        }
    }
    

private static String gerarHash(String senha) {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(senha.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}
        private static void commandcenter() {
        clear();
        Scanner input = new Scanner(System.in);
        System.out.println("Namic BexNit - The Blu3sky");
        
        while (true) {
            System.out.print("-> ");
            String command = input.nextLine();
            
            if (command.equalsIgnoreCase("config=reset-user")) {
                System.out.println("AVISO!: ");
                System.out.println("Ao fazer isso, você perderá tudo! confirme se deseja deletar!");
                System.out.print("Confirme (y/n): ");
                String confirmacao = input.nextLine();

                if (confirmacao.equalsIgnoreCase("y")) {
                    File arquivo = new File("BexNit/Save.xml");
                    if (arquivo.delete()) {
                        System.out.println("Deletando Save.xml...");
                        sleep(2000);
                        System.out.println("Executando config...");
                        sleep(2000);
                        clear();
                        config();
                        return;
                    } else {
                        System.out.println("Erro: Não foi possível deletar o arquivo.");
                    }
                } else {
                    System.out.println("Abortado.");
                }
            }
            else if (command.equalsIgnoreCase("climip")) {
                clear();
            }
            else if (command.equalsIgnoreCase("setdata = config,bn.states.developer = 0a4edeveloper6a,config = +states.e4er.control = states,sys.down = states,sys.xml,save / efile,states=sys,Yes")) {
                developer = "Yes";
            gds();
            save();
            } 
            else if (command.equalsIgnoreCase("setdata = config,bn.states.developer = 0a4edeveloper6a,config = +states.e4er.control = states,sys.down = states,sys.xml,save / efile,states=sys,No")) {
                developer = "No";
            save();
            }
            else if (command.equals("devset")) {
                if (developer.equals("Yes")) {
                    Core.devset();
                }
            else if (developer.equals("No")) {
                ipo("Acesso negado!");
            }
            }
            else if (command.equalsIgnoreCase("dgvm = data / config,bn.states.Querys.dlvm.dgvm.config.Manage / no-supervision / no-reset /config,set")) {
                config();
            }
            else if (command.equalsIgnoreCase("readStates")) {
                ipo("\nNome: " + name);
            ipo("\nIdade: " + age);
            ipo("\nNome ficticio: " + nf);
            ipo("\nVerificado: " + va);
            ipo("\nDono/Criadores: " + developer);
            }
            else if (command.equalsIgnoreCase("exit")) {
                return; 
            }
            else if (command.startsWith("ipo")) {
    if (command.trim().equalsIgnoreCase("ipo")) {
        System.out.println("ipo: binário está sem comando");
    }
             if (command.trim().isEmpty()) {
        }
    else if (command.startsWith("ipo ")) {
        String mensagem = command.substring(4);
        ipo(mensagem);
    }
            else {
                String sugestao = command.substring(3);
        System.out.println("\nipo: Você quis dizer 'ipo " + sugestao + "'?");
    }
}
            else {
                System.out.println("Comando invalido!");
            }
        }
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void save() {
        File pasta = new File("BexNit");

        if (!pasta.exists()) {
            pasta.mkdir();
        }

        File arquivo = new File(pasta, "Save.xml");

        try {
            FileWriter escritor = new FileWriter(arquivo);
            
            escritor.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            escritor.write("<BexNit xmlns=\"http://schemas.bn.com/file\">\n");
            escritor.write("    <User>\n");
            escritor.write("        <RealName>" + name + "</RealName>\n");
            escritor.write("        <Age>" + age + "</Age>\n");
            escritor.write("        <FictitiousName>" + nf + "</FictitiousName>\n");
            escritor.write("    </User>\n");
            escritor.write("    <Data>\n");
            escritor.write("        <VerifiedAge>" + va + "</VerifiedAge>\n");
            escritor.write("        <Password>" + password + "</Password>\n");
            escritor.write("        <developer>" + developer + "</developer>\n");
            escritor.write("    </Data>\n");
            escritor.write("    <DataDeveloper>\n");
            escritor.write("        <PasswordDv>" + passworddeveloper + "</Password>\n");
            escritor.write("    </DataDeveloper>\n");
            escritor.write("</BexNit>");

            
            escritor.close();
        } catch (Exception e) {
            System.out.println("BNE: Error to save");
        }
    }
    
    public static void load() {
    File arquivo = new File("BexNit/Save.xml");
    if (!arquivo.exists()) return;

    try (Scanner leitor = new Scanner(arquivo)) {
        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine().trim();
            
            if (linha.contains("<RealName>"))       name = tag(linha);
            if (linha.contains("<Age>"))            age = Integer.parseInt(tag(linha));
            if (linha.contains("<FictitiousName>")) nf = tag(linha);
            if (linha.contains("<VerifiedAge>"))    va = tag(linha);
            if (linha.contains("<Password>"))       password = tag(linha);
            if (linha.contains("<developer>"))      developer = tag(linha);
            if (linha.contains("<PasswordDv>"))     passworddeveloper = tag(linha);
        }
    } catch (Exception e) {
        System.out.println("BNE: Erro ao carregar os dados!");
    }
}
    
private static String tag(String linha) {
    try {
        return linha.substring(linha.indexOf(">") + 1, linha.lastIndexOf("<"));
    } catch (Exception e) {
        return "";
    }
}


    private static String extrairValor(String linha) {
    if (linha == null || !linha.contains(">") || !linha.contains("</")) {
        return ""; 
    }
    try {
        return linha.substring(linha.indexOf(">") + 1, linha.lastIndexOf("<"));
    } catch (Exception e) {
        return "";
    }
}

    public static void config() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("[Login]");

        System.out.print("Qual seu nome?: ");
        name = teclado.nextLine();

        
        System.out.print("Quantos anos você tem?: ");
        age = teclado.nextInt(); 
        teclado.nextLine();
        
        if (age < 13) {
            System.out.println("Infelizmente não aceitamos pessoas abaixo de 13 anos");
        System.exit(0);
        }

        System.out.println("Oi " + name + "! Uou " + age + " Anos Fantastico!");

        sleep(1200);
        System.out.print("Qual seu nome ficticio?: ");
        nf = teclado.nextLine();
        System.out.print("Digite uma senha: ");
        String senhaPura = teclado.nextLine();
        password = gerarHash(senhaPura);
        sleep(1200);
        
        System.out.println("[Verificar idade]");
        sfloadverifycore();

        System.out.println("[Confirmação de criação de conta]");
        System.out.print("Deseja criar a conta? (y/n): ");
        String confirm = teclado.nextLine();

        if (confirm.equals("y")) {
            developer = "No";
            save(); 
        } else if (confirm.equals("n")) {
            System.out.println("Criação de conta cancelada");
            System.exit(0);
        } else {
            System.out.println("Opção invalida, eu vou considerar como y");
            save(); 
        }
    }

    public static void main(String[] args) {
        clear();
        System.out.println("BexNit");
        System.out.println("O menu offline, use em caso de viagens longas");
        System.out.println("Criador: The Blu3sky");
        ipo("");
        ipo("");
        ipo("");
        ipo("");
        ipo("");
        ipo("");
        ipo("Acesse meu canal: https://youtube.com/@th3blu3sk6?si=j5YzURXugwJnehSp");
        ipo("Acesse meu discord: https://discord.gg/hE5g9WzQbh");
        ipo("Acesse meu tiktok: https://tiktok.com/@the.blu3sky");
        
        sleep(2000);
        clear();
        File arquivo = new File("BexNit/Save.xml");
    if (arquivo.exists()) {
    load();
        Scanner reader = new Scanner(System.in);
    System.out.print("Digite sua senha: ");
  String entrada = reader.nextLine();

    if (gerarHash(entrada).equals(password)) {
    } else if (entrada.equals("e4er=commandcenter")) {
        commandcenter();
        return;
    } else if (gerarHash(entrada).equals(passworddeveloper)) {
        developermenu();
    }
        else {
        System.out.println("Senha incorreta!");
        System.exit(0);
    }
} else {
    config();
}


    clear();
    System.out.println("\nBem-Vindo De volta, " + nf + "!");
        sleep(3000);
        clear();
        menu();
    }
    public static void menu() {
        Scanner tecladomenu = new Scanner(System.in);
        while (true) {
            clear();
            System.out.println("BexNit -- Menu");
            System.out.println("1. Piadas");
            ipo("2. SFload");
            System.out.println("0. Sair");
            System.out.print("Selecione: ");
            menu = tecladomenu.nextLine();
            if (menu.equals("1")) {
                clear();
                String[] piadas = {
                    "O que a parede disse pra outra? eu não sei pq que a gente é fundido ;-;",
                    "O que o peixe foi fazer no mar? pra nadar",
                    "O que a argola disse pra outra? eu vou segurar aquela arvore",
                    "O que o lento disse pro rapido? ele disse, calma, eu não sou o flash",
                    "O que o nada disse pro tudo? tome nada, já que eu sou o nada",
                    "O que o preto disse pro branco? branco",
                    "O que o double disse pro int? números",
                    "O que o null disse pro infinite? nada",
                    "O que o sistema disse pro /dev/null? não me coma"
                };
                Random adp = new Random();
                int iwj = adp.nextInt(piadas.length);
                
                String rpi = piadas[iwj];
                
                System.out.println(rpi);
                sleep(6000);
            }
            else if (menu.equals("2")) {
                sfload();
            }
            else if (menu.equals("0")) {
                clear();
                System.out.println("Saindo...");
            sleep(1200);
            break;
            }
            else {
                clear();
                System.out.println("\nOpção invalida! " + menu + " não é reconhecido!");
                sleep(2000);
            }
        }
    }
}

class Core {
    static double version = 1.0;
    static String devset;
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
    public static void devset() {
        Scanner reader = new Scanner(System.in);
        while (true) {
        clear();
        System.out.println("DevSet - Developer Settings");
        System.out.println("1. Versão do BexNit");
System.out.println("0. Sair");
        System.out.print("Selecione: ");
        devset = reader.nextLine();
        if (devset.equals("1")) {
            clear();
            System.out.println("\nVersão: " + version);
            sleep(1200);
        }
            else if (devset.equals("0")) {
                clear();
                break;
            }
        else {
            clear();
            System.out.println("Opção invalida!");
            sleep(1200);
            }
        }
    }
}
