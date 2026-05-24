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
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipFile;

public class Main extends Core {
    private static String name;
    private static int age;
    private static String nf;
    private static String menu;
    private static String password;
    private static String developer;
    private static String idadeStr;
    private static String senhaToken;
    private static String passworddeveloper = "not";
    private static String mdev;
    private static double version = 1.0;
    private static String creators = "The Blu3sky";
    private static String jogos;
    private static String jda;
    private static String set;
    static {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
    }
    
    private static void gds() {}
    private static void ipo(String msg) { System.out.println(msg); }
    private static void developermenu() {}
    
    private static String io;
    private static boolean nn;
    private static boolean initr;
    private static String cinit = "";
    public static void init() {
        io = "SLInit";
        nn = true;
        initr = true;
    }
    
    private static String lerEntradaZip(java.util.zip.ZipFile zip, String caminhoEntrada) {
    try {
        java.util.zip.ZipEntry entry = zip.getEntry(caminhoEntrada);
        if (entry != null) {
            try (InputStream is = zip.getInputStream(entry)) {
                return new String(is.readAllBytes(), "UTF-8");
            }
        }
    } catch (IOException e) {
    }
    return "";
}

    
    private static void importarSave() {
    clear();
    System.out.println("BexNit - Importar Save");

    File pastaInput = new File("Input");
    if (!pastaInput.exists()) {
        pastaInput.mkdir();
    }

    File[] todosArquivos = pastaInput.listFiles();
    int totalZips = 0;

    if (todosArquivos != null) {
        for (File arq : todosArquivos) {
            if (arq.isFile() && arq.getName().toLowerCase().endsWith(".zip")) {
                totalZips++;
            }
        }
    }

    if (totalZips == 0) {
        System.out.println("\nNenhum arquivo .zip encontrado na pasta Input/");
        System.out.println("Coloque o seu arquivo de backup lá e tente novamente.");
        sleep(4000);
        return;
    }

    File[] apenasZips = new File[totalZips];
    int indice = 0;
    
    System.out.println("\nSaves disponíveis:");
    for (File arq : todosArquivos) {
        if (arq.isFile() && arq.getName().toLowerCase().endsWith(".zip")) {
            apenasZips[indice] = arq;
            System.out.println((indice + 1) + ". " + arq.getName());
            indice++;
        }
    }

    Scanner teclado = new Scanner(System.in);
    System.out.print("\nEscolha: ");
    
    int escolhaNum;
    try {
        escolhaNum = Integer.parseInt(teclado.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("\nNúmero inválido!");
        sleep(2000);
        return;
    }

    if (escolhaNum < 1 || escolhaNum > totalZips) {
        System.out.println("\nOpção fora da lista");
        sleep(2000);
        return;
    }

    File arquivoZip = apenasZips[escolhaNum - 1];
    System.out.println("\nCarregando... : " + arquivoZip.getName() + "...");

    try (ZipFile zip = new ZipFile(arquivoZip)) {
        String raiz = "BexNit/";
        String pastaUser = raiz + "User/";
        String pastaSystem = raiz + "System/";
        String pastaData = raiz + "Data/";
        String pastaDataDev = raiz + "DataDeveloper/";

        name = lerEntradaZip(zip, pastaUser + "RealName");
        
        String idadeStr = lerEntradaZip(zip, pastaUser + "Age");
        if (!idadeStr.isEmpty()) {
            age = Integer.parseInt(idadeStr);
        }
        
        nf = lerEntradaZip(zip, pastaUser + "FicticiousName");
        cinit = lerEntradaZip(zip, pastaSystem + "ConfirmedInit");
        password = lerEntradaZip(zip, pastaData + "Password");
        developer = lerEntradaZip(zip, pastaData + "developer");
        passworddeveloper = lerEntradaZip(zip, pastaDataDev + "PasswordDv");

        if (passworddeveloper.isEmpty()) {
            passworddeveloper = "not";
        }

        save();

        System.out.println("\nSave restaurado! aproveite");
        sleep(3000);

    } catch (Exception e) {
        System.out.println("\nErro ao importar o arquivo ZIP: " + e.getMessage());
        sleep(3000);
    }
}

    
    private static void exportarSave() {
    clear();
    System.out.println("Exportando Save.xml");

        java.io.File pastaOutput = new java.io.File("Output");
    if (!pastaOutput.exists()) {
        pastaOutput.mkdir();
    }
        
    String nomeZip = "Output/BexNit_Save_" + (nf != null && !nf.isEmpty() ? nf : "Dados") + ".zip";

    try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(nomeZip))) {
        
        String raiz = "BexNit/";
        zos.putNextEntry(new ZipEntry(raiz));
        zos.closeEntry();

        String pastaUser = raiz + "User/";
        zos.putNextEntry(new ZipEntry(pastaUser));
        zos.closeEntry();

        if (name != null) {
            zos.putNextEntry(new ZipEntry(pastaUser + "RealName"));
            zos.write(name.getBytes("UTF-8"));
            zos.closeEntry();
        }

        zos.putNextEntry(new ZipEntry(pastaUser + "Age"));
        zos.write(String.valueOf(age).getBytes("UTF-8"));
        zos.closeEntry();

        if (nf != null) {
            zos.putNextEntry(new ZipEntry(pastaUser + "FicticiousName"));
            zos.write(nf.getBytes("UTF-8"));
            zos.closeEntry();
        }

        String pastaSystem = raiz + "System/";
        zos.putNextEntry(new ZipEntry(pastaSystem));
        zos.closeEntry();

        if (cinit != null) {
            zos.putNextEntry(new ZipEntry(pastaSystem + "ConfirmedInit"));
            zos.write(cinit.getBytes("UTF-8"));
            zos.closeEntry();
        }

        String pastaData = raiz + "Data/";
        zos.putNextEntry(new ZipEntry(pastaData));
        zos.closeEntry();

        if (password != null) {
            zos.putNextEntry(new ZipEntry(pastaData + "Password"));
            zos.write(password.getBytes("UTF-8"));
            zos.closeEntry();
        }

        if (developer != null) {
            zos.putNextEntry(new ZipEntry(pastaData + "developer"));
            zos.write(developer.getBytes("UTF-8"));
            zos.closeEntry();
        }

        String pastaDataDev = raiz + "DataDeveloper/";
        zos.putNextEntry(new ZipEntry(pastaDataDev));
        zos.closeEntry();

        if (passworddeveloper != null) {
            zos.putNextEntry(new ZipEntry(pastaDataDev + "PasswordDv"));
            zos.write(passworddeveloper.getBytes("UTF-8"));
            zos.closeEntry();
        }

        System.out.println("\nSave exportado com sucesso!: " + nomeZip);
        sleep(3000);

    } catch (IOException e) {
        System.out.println("\nErro ao gerar o Save: " + e.getMessage());
        sleep(3000);
    }
}

    
    private static void informations() {
        // apenas informações, não sei pq
        clear();
        System.out.println("\nVersão: " + version);
        System.out.println("\nCriadores: " + creators);
        sleep(3000);
    }
    private static void errorcinit() {
        clear();
        System.out.println("System Inicialization Error");
        System.out.println("Error initializing BexNit, the initialization system is broken, contact a BexNit specialist at suportecynupsengine@hotmail.com");
        System.out.println("Error: 561 - BexNit");
        Core.exitbn(1);
    }
    private static void secretPerfil() {
        // perfil secreto pra ninguém esquecer o RG do BexNit kkkkk
        clear();
        System.out.println("\nNome: " + name);
        System.out.println("\nIdade: " + age);
        System.out.println("\nNome Ficticio: " + nf);
        sleep(3000);
    }
    
    private static void settings() {
        // Configurações né, quem não gosta de uma configuraçãozinha? kkkkk
        Scanner reader = new Scanner(System.in);
        while (true) {
            clear();
            System.out.println("BexNit - Settings");
            System.out.println("1. Perfil Secreto");
            System.out.println("2. Informações");
            System.out.println("0. Sair");
            System.out.print("Selecione: ");
            
            set = reader.nextLine();
            
            if (set.equals("1")) {
                secretPerfil();
            }
            else if (set.equals("2")) {
                informations();
            }
            else if (set.equals("0")) {
                break;
            }
            else {
                clear();
                System.out.println("Opção invalida!");
                sleep(3000);
            }
        }
    }
    
    private static void jogodecontador() {
        Scanner sc = new Scanner(System.in);
        int clicks = 0;
        while (true) {
            // Jogo de clique, talvez essa seja a minha pior escolha de vida...
            clear();
            System.out.println("BexNit - Jogo pra testar cliques");
            System.out.println("Aperte 1 e enter pra contar e /e pra sair");
            System.out.println("\nCliques: " + clicks);
            System.out.print("Clique: ");
            
            String scba = sc.nextLine();
            
            if (scba.equals("1")) {
                // Tá parecendo c++ kkkkKkkkkkkKKKKKKK
                clicks++;
            }
            else if (scba.equals("/e")) {
                break;
            }
        }
    }
    
    private static void jogodeadivinhacao() {
        Random rca = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int secretNumber = rca.nextInt(100) + 1; 
        int tentatives = 0;
        
        System.out.println("BexNit - Jogo de Adivinhação");
        System.out.println("Tente adivinhar o número que pensei entre 1 e 100!");
        while (true) {
            // MELHOR ESCOLHA DA MINHA VIDA KKKKK
            clear();
            System.out.print("Adivinhe o número: ");
            
            if (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido!");
            scanner.next();
            continue;
        }
            int palpite = scanner.nextInt();
        tentatives++;
            
        if (palpite == secretNumber) {
            System.out.println("\nParabéns! Você acertou em " + tentatives + " tentativas!");
            sleep(3000);
            break;
        } else if (palpite < secretNumber) {
            System.out.println("O número secreto é MAIOR. Tente novamente.");
            sleep(3000);
        } else {
            System.out.println("O número secreto é MENOR. Tente novamente.");
            sleep(3000);
        }
        }
    }
    
    private static void jogos() {
        Scanner reader = new Scanner(System.in);
        while (true) {
            // Hubzinho de jogos certinho... é... pelo o menos é melhor que nada
            clear();
        System.out.println("BexNit - Jogos");
        System.out.println("1. Jogo de Adivinhação");
            System.out.println("2. Jogo de Contador");
            System.out.println("0. Sair");
        System.out.print("Selecione: ");
        
        jogos = reader.nextLine();
        
        if (jogos.equals("1")) {
            jogodeadivinhacao();
           }
            else if (jogos.equals("2")) {
                jogodecontador();
            }
            else if (jogos.equals("0")) {
                break;
            }
            else {
                clear();
                System.out.println("Opção invalida!");
                sleep(3000);
            }
        }
    }
    
private static void sfload() {
    Scanner reader = new Scanner(System.in);
    clear();
    System.out.println("SFload Interact");
    System.out.println("Digite /exit para sair");
    System.out.println("AVISO: SFload pode parecer um humano, mas ele é uma inteligência artificial.");
    System.out.println("Não compartilhe dados pessoais ou segredos. Não lidaremos com qualquer erro seu.");
    System.out.println("");
    
    String[] diretrizes = {
   "abuso", "sexual", "homosexual", "fuder", "disgraça", "puta", "caralho", "assedio"
    };

    
    while (true) {
        System.out.print("-> ");
        String message = reader.nextLine();
        String msgMinuscula = message.toLowerCase();

        if (message.equalsIgnoreCase("Acorde!")) {
            String[] resposta = {
                "... ah oi",
                "... por... oi...",
                "... oi...",
                "o-oi👉👈",
                "Oi Tudo Bem?👉👈"
            };
            Random rdm = new Random();
            int adpi = rdm.nextInt(resposta.length); 
            String mlp = resposta[adpi]; 
            System.out.println("\nSFload: " + mlp);
            sleep(3000);
        }
        else if (verificarDiretrizes(msgMinuscula, diretrizes)) {
            System.out.println("\nSFload: Infelizmente não podemos tomar rumo a conversa, sinto que isso não está seguro pra si, isso não está de acordo com minhas diretrizes");
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
        else if (message.equalsIgnoreCase("/clean --screen")) {
            clear();
        }
        else if (message.equalsIgnoreCase("/i")) {
            System.out.println("q-que?")
        }
        else if (message.toLowerCase().contains("acorda d*sgraça")) {
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
        else if (message.equalsIgnoreCase("Oi")) {
            String[] resposta = {
                "Oi👉👈",
                "... Oi👉👈",
                "... O-Oi👉👈"
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
        else if (message.startsWith("/e ")) {
            System.out.println("SFload: Sair?");
            sleep(3000);
            System.out.println("SFload: Tá...");
            sleep(3000);
            System.out.println("* SFload vai desligar o programa BexNit *");
            sleep(3000);
            Core.exitbn(0);
        }
        else if (msgMinuscula.contains("conversar")) {
            System.out.println("SFload: C-Conversar? 👉👈");
            sleep(3000);
            System.out.println("* SFload se esconde atrás de um livro *");
            sleep(3000);
        }
        else {
            System.out.println("SFload: ...");
        }
    }
}
private static boolean verificarDiretrizes(String msg, String[] lista) {
    for (String palavra : lista) {
        if (msg.contains(palavra)) {
            return true;
        }
    }
    return false;
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
            else if (command.equalsIgnoreCase("broken cinit/c in")) {
                cinit = "";
            save();
            Core.exitbn(0);
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
            escritor.write("    <System>\n");
            escritor.write("        <ConfirmedInit>" + cinit + "</ConfirmedInit>\n");
            escritor.write("    </System>\n");
            escritor.write("    <Data>\n");
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
            if (linha.contains("<Password>"))       password = tag(linha);
            if (linha.contains("<developer>"))      developer = tag(linha);
            if (linha.contains("<PasswordDv>"))     passworddeveloper = tag(linha);
            if (linha.contains("<ConfirmedInit>"))     cinit = tag(linha);
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
        cinit = "Verdadeiro";
        save();
        Scanner teclado = new Scanner(System.in);
        System.out.println("[Login]");

        System.out.print("Qual seu nome?: ");
        name = teclado.nextLine();

        
        System.out.print("Quantos anos você tem?: ");
        age = teclado.nextInt(); 
        teclado.nextLine();
        
        if (age < 6) {
            System.out.println("Infelizmente não aceitamos pessoas abaixo de 6 anos");
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
        
           if (cinit.equals("Verdadeiro")) {
            
        }
        else if (cinit.equals("Falso")) {
            errorcinit();
        }
        else if (cinit.equals("")) {
            errorcinit();
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
            System.out.println("2. SFload");
            System.out.println("3. Jogos");
            System.out.println("4. Centro de comando");
            System.out.println("5. Exportar Save.xml");
            System.out.println("6. Importar Save.xml");
            System.out.println("7. Configurações");
            System.out.println("0. Sair");
            System.out.print("Selecione: ");
            menu = tecladomenu.nextLine();
            if (menu.equals("1")) {
                clear();
                String[] piadas = {
                    "O que a parede disse pra outra? eu não sei pq que a gente é fundido ;- bitumen",
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
            else if (menu.equals("3")) {
                jogos();
            }
            else if (menu.equals("4")) {
                commandcenter();
            }
            else if (menu.equals("5")) {
                exportarSave();
            }
            else if (menu.equals("6")) {
                importarSave();
            }
            else if (menu.equals("7")) {
                settings();
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
    private static double version = 1.0;
    private static String devset;
    public static String Sysexecute;
    private static boolean aemo;
    
    public static void data() {
        boolean EXECUTE = true;
        aemo = false;
    }
    public static void exitbn(int m) {
        System.exit(0);
    }
    
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clear() {
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
