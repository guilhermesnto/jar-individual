package projeto.login;

        import projeto.conexao.Conectar;
        import projeto.menu.Menu;
        import projeto.print.Prints;

        import java.util.Scanner;

public class Login {
    String username;
    private String token;
    private String telefone;
    private Boolean logado = false;
    private String escolha = null;

    Menu menu = new Menu();
    Conectar conectar = new Conectar();
    Scanner scanner = new Scanner(System.in);
    Prints prints = new Prints();
    public Boolean login() {
        Integer n = 0;
        while (!logado) {
            prints.limparConsole();
                if (n == 0) {
                    prints.username();
                    scanner.next();
                    username = scanner.nextLine();
                    prints.token();
                    token = scanner.nextLine();

                    logado = conectar.Logar(username, token);
                    n++;
                } else {
                    System.out.println("""
                                        
                    Nenhum usuario encontrado
                                        
                    Por favor verifique as credenciais
                    
                    1 - Tentar Novamente
                    2 - Esqueci meu token
                    """);
                    scanner.next();
                    escolha = scanner.nextLine();
                    if (escolha.equals("1")) {
                        prints.username();
                        scanner.next();
                        username = scanner.nextLine();
                        prints.token();
                        token = scanner.nextLine();
                        logado = conectar.Logar(username, token);

                    } else {
                        System.out.println("Para continuar com seu login informe seu telefone");
                        telefone = scanner.nextLine();
                        logado = conectar.Logar(telefone);
                    }
                n = 0;
                }

            }

        return true;
    }
}



