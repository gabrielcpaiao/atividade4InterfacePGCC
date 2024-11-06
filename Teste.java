import java.util.Scanner;

public class Teste {

    private final static Passeio passeio = new Passeio();
    private final static Carga carga = new Carga();

    private final static Passeio vetPasseio[] = new Passeio[5];
    private final static Carga vetCarga[] = new Carga[5];

    private final static Leitura l = new Leitura();

    private static int indicePasseio = 0;
    private static int indiceCarga = 0;

    public static void main(String[] args) {
        Teste teste = new Teste();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n============================================");
            System.out.println("\nSistema de Gestao de Veiculos - Menu Inicial \n");
            System.out.println("============================================\n");
            System.out.println("1) Cadastrar Veículo de Passeio");
            System.out.println("2) Cadastrar Veículo de Carga");
            System.out.println("3) Imprimir Todos os Veiculos de Passeio");
            System.out.println("4) Imprimir Todos os Veiculos de Carga");
            System.out.println("5) Imprimir Veículo de Passeio pela Placa");
            System.out.println("6) Imprimir Veículo de Carga pela Placa");
            System.out.println("7) Sair do Sistema");
            System.out.print("\nEscolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    teste.cadastrarPasseio();
                    break;
                case 2:
                    teste.cadastrarCarga();
                    break;
                case 3:
                    teste.imprimirTodosPasseio();
                    break;
                case 4:
                    teste.imprimirTodosCarga();
                    break;
                case 5:
                    teste.imprimirPasseioPorPlaca();
                    break;
                case 6:
                    teste.imprimirCargaPorPlaca();
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção invalida. Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    private boolean placaExiste(String placa) {
        for (int i = 0; i < indicePasseio; i++) {
            if (vetPasseio[i].getPlaca().equalsIgnoreCase(placa)) {
                return true; // Placa já cadastrada
            }
        }
        return false; // Placa não encontrada
    }

    public void cadastrarPasseio() {
        do {
            String placa = l.entDados("\nDigite a placa do veiculo de passeio: ");

            // Verifica se a placa já existe
            if (placaExiste(placa)) {
                System.out.println("Veículo com a placa (" + placa + ") ja esta cadastrado. Voltando ao menu inicial.");
                return; // Retorna ao menu inicial
            }

            if (indicePasseio < vetPasseio.length) {
                Passeio veiculoPasseio = new Passeio();

                veiculoPasseio.setPlaca(placa);
                veiculoPasseio.setMarca(l.entDados("Digite a marca do veiculo de passeio: "));
                veiculoPasseio.setModelo(l.entDados("Digite o modelo do veiculo de passeio: "));
                veiculoPasseio.setCor(l.entDados("Digite a cor do veiculo de passeio: "));
                veiculoPasseio
                        .setVelocMax(
                                Float.parseFloat(l.entDados("Digite a velocidade maxima do veiculo de passeio: ")));
                veiculoPasseio
                        .setQtdRodas(
                                Integer.parseInt(l.entDados("Digite a quantidade de rodas do veiculo de passeio: ")));
                veiculoPasseio.setQtdPassageiros(
                        Integer.parseInt(l.entDados("Digite a quantidade de passageiros do veiculo de passeio: ")));
                veiculoPasseio.getMotor().setQtdPist(Integer.parseInt(l.entDados("Qtd Pistoes do motor: ")));
                veiculoPasseio.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do motor: ")));

                vetPasseio[indicePasseio] = veiculoPasseio;
                indicePasseio++;

                System.out.println("===== Veiculo de Passeio Cadastrado =====");
                System.out.println("\nPlaca := " + veiculoPasseio.getPlaca());
                System.out.println("Marca := " + veiculoPasseio.getMarca());
                System.out.println("Modelo := " + veiculoPasseio.getModelo());
                System.out.println("Cor := " + veiculoPasseio.getCor());
                System.out.println("Velocidade Maxima (km/h) := " + veiculoPasseio.getVelocMax());
                // System.out.println("Velocidade Maxima (m/h) := " + veiculoPasseio.calcVel(veiculoPasseio.getVelocMax()));
                System.out.println("Quantidade de rodas := " + veiculoPasseio.getQtdRodas());
                System.out.println("Qtd Passageiros := " + veiculoPasseio.getQtdPassageiros());
                System.out.println("Qtd Pistoes Motor := " + veiculoPasseio.getMotor().getQtdPist());
                System.out.println("Potencia do Motor := " + veiculoPasseio.getMotor().getPotencia());

                System.out.println("\nVeiculo de passeio cadastrado com sucesso!");
            } else {
                System.out.println("Não é possível cadastrar mais veículos de passeio. O vetor está cheio.");
                return;
            }

            // Pergunta se o usuário deseja cadastrar outro veículo
            String resposta = l.entDados("Deseja cadastrar mais um veiculo de passeio? (s/n): ");
            if (resposta.equalsIgnoreCase("n")) {
                System.out.println("Voltando ao menu inicial.");
                return; // Retorna ao menu inicial se o usuário responder "Não"
            }

        } while (true);
    }

    private boolean placaExisteCarga(String placa) {
        for (int i = 0; i < indiceCarga; i++) {
            if (vetCarga[i].getPlaca().equalsIgnoreCase(placa)) {
                return true; // Placa já cadastrada
            }
        }
        return false; // Placa não encontrada
    }

    public void cadastrarCarga() {
        do {
            String placa = l.entDados("\nDigite a placa do veiculo de carga: ");

            // Verifica se a placa já existe
            if (placaExisteCarga(placa)) {
                System.out.println("Veículo com a placa (" + placa + ") ja esta cadastrado. Voltando ao menu inicial.");
                return; // Retorna ao menu inicial
            }

            if (indiceCarga < vetCarga.length) {
                Carga veiculoCarga = new Carga();

                veiculoCarga.setPlaca(placa);
                veiculoCarga.setMarca(l.entDados("Digite a marca do veiculo de carga: "));
                veiculoCarga.setModelo(l.entDados("Digite o modelo do veiculo de carga: "));
                veiculoCarga.setCor(l.entDados("Digite a cor do veiculo de carga: "));
                veiculoCarga
                        .setVelocMax(Float.parseFloat(l.entDados("Digite a velocidade maxima do veiculo de carga: ")));
                veiculoCarga
                        .setQtdRodas(
                                Integer.parseInt(l.entDados("Digite a quantidade de rodas do veiculo de carga: ")));
                veiculoCarga.setCargaMax(Integer.parseInt(l.entDados("Digite a carga maxima do veiculo de carga: ")));
                veiculoCarga.setTara(Integer.parseInt(l.entDados("Digite a tara do veiculo de carga: ")));
                veiculoCarga.getMotor().setQtdPist(Integer.parseInt(l.entDados("Qtd Pistoes do motor: ")));
                veiculoCarga.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do motor: ")));

                vetCarga[indiceCarga] = veiculoCarga;
                indiceCarga++;

                System.out.println("\nPlaca := " + veiculoCarga.getPlaca());
                System.out.println("Marca := " + veiculoCarga.getMarca());
                System.out.println("Modelo := " + veiculoCarga.getModelo());
                System.out.println("Cor := " + veiculoCarga.getCor());
                System.out.println("Velocidade Maxima (km/h) := " + veiculoCarga.getVelocMax());
                // System.out.println("Velocidade Maxima (cm/h) := " + veiculoCarga.calcVel(veiculoCarga.getVelocMax()));
                System.out.println("Quantidade de Rodas: " + veiculoCarga.getQtdRodas());
                System.out.println("Carga maixma := " + veiculoCarga.getCargaMax());
                System.out.println("Tara := " + veiculoCarga.getTara());
                System.out.println("Qtd Pistoes Motor := " + veiculoCarga.getMotor().getQtdPist());
                System.out.println("Potencia do Motor := " + veiculoCarga.getMotor().getPotencia());

                System.out.println("\nVeiculo de Carga cadastrado com sucesso!");
            } else {
                System.out.println("Não é possível cadastrar mais veículos de carga. O vetor está cheio.");
                return;
            }

            String resposta = l.entDados("Deseja cadastrar mais um veiculo de passeio? (s/n): ");
            if (resposta.equalsIgnoreCase("n")) {
                System.out.println("Voltando ao menu inicial.");
                return; // Retorna ao menu inicial se o usuário responder "Não"
            }
        } while (true);
    }

    public void imprimirTodosPasseio() {
        System.out.println("\nVeiculos de Passeio Cadastrados:");
        for (Passeio p : vetPasseio) {
            if (p != null) {
                System.out.println("===== Veiculo de Passeio Cadastrado: =====");
                System.out.println("\nPlaca := " + p.getPlaca());
                System.out.println("Marca := " + p.getMarca());
                System.out.println("Modelo := " + p.getModelo());
                System.out.println("Cor := " + p.getCor());
                System.out.println("Velocidade Maxima (km/h) := " + p.getVelocMax());
                // System.out.println("Velocidade Maxima (m/h) := " + p.calcVel(p.getVelocMax()));
                System.out.println("Quantidade de Rodas: " + p.getQtdRodas());
                System.out.println("Qtd Passageiros := " + p.getQtdPassageiros());
                System.out.println("Qtd Pistoes Motor := " + p.getMotor().getQtdPist());
                System.out.println("Potencia do Motor := " + p.getMotor().getPotencia());
            }
        }
    }

    public void imprimirTodosCarga() {
        System.out.println("Veiculos de Carga Cadastrados:");
        for (Carga c : vetCarga) {
            if (c != null) {
                System.out.println("\nPlaca := " + c.getPlaca());
                System.out.println("Marca := " + c.getMarca());
                System.out.println("Modelo := " + c.getModelo());
                System.out.println("Cor := " + c.getCor());
                System.out.println("Velocidade Maxima (km/h) := " + c.getVelocMax());
                // System.out.println("Velocidade Maxima (cm/h) := " + c.calcVel(c.getVelocMax()));
                System.out.println("Quantidade de Rodas: " + c.getQtdRodas());
                System.out.println("Carga maixma := " + c.getCargaMax());
                System.out.println("Tara := " + c.getTara());
                System.out.println("Qtd Pistoes Motor := " + c.getMotor().getQtdPist());
                System.out.println("Potencia do Motor := " + c.getMotor().getPotencia());
                // System.out.println("Valor calculado Interface := " + c.calcular());
            }
        }
    }

    public void imprimirPasseioPorPlaca() {
        String placa = l.entDados("Digite a placa do veiculo de passeio para imprimir:");
        for (Passeio p : vetPasseio) {
            if (p != null && p.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Veiculo de Passeio Encontrado:");
                System.out.println("\nPlaca := " + p.getPlaca());
                System.out.println("Marca := " + p.getMarca());
                System.out.println("Modelo := " + p.getModelo());
                System.out.println("Cor := " + p.getCor());
                System.out.println("Velocidade Maxima (km/h) := " + p.getVelocMax());
                System.out.println("Velocidade Maxima (m/h) := " + p.calcVel(p.getVelocMax()));
                System.out.println("Quantidade de Rodas: " + p.getQtdRodas());
                System.out.println("Qtd Passageiros := " + p.getQtdPassageiros());
                System.out.println("Qtd Pistoes Motor := " + p.getMotor().getQtdPist());
                System.out.println("Potencia do Motor := " + p.getMotor().getPotencia());
                System.out.println("Valor calculado Interface := " + p.calcular());
                return;
            }
        }
        System.out.println("Veiculo de passeio com placa " + placa + " não encontrado.");
    }

    public void imprimirCargaPorPlaca() {
        String placa = l.entDados("Digite a placa do veiculo de carga para imprimir:");
        for (Carga c : vetCarga) {
            if (c != null && c.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Veiculo de Carga Encontrado:");

                System.out.println("\nPlaca := " + c.getPlaca());
                System.out.println("Marca := " + c.getMarca());
                System.out.println("Modelo := " + c.getModelo());
                System.out.println("Cor := " + c.getCor());
                System.out.println("Velocidade Maxima (km/h) := " + c.getVelocMax());
                System.out.println("Velocidade Maxima (cm/h) := " + c.calcVel(c.getVelocMax()));
                System.out.println("Quantidade de Rodas: " + c.getQtdRodas());
                System.out.println("Carga maixma := " + c.getCargaMax());
                System.out.println("Tara := " + c.getTara());
                System.out.println("Qtd Pistoes Motor := " + c.getMotor().getQtdPist());
                System.out.println("Potencia do Motor := " + c.getMotor().getPotencia());
                System.out.println("Valor calculado Interface := " + c.calcular());
                return;
            }
        }
        System.out.println("Veiculo de carga com placa " + placa + " não encontrado.");
    }
}
