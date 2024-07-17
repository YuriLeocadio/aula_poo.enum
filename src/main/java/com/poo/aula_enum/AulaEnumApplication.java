package com.poo.aula_enum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class AulaEnumApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaEnumApplication.class, args);

		limpa();
		Scanner sc = new Scanner(System.in);

		System.out.println("Escolha uma atividade:");
		System.out.println("1. Escolher uma UF");
		System.out.println("2. Escolher uma Região");
		System.out.print("Opção: ");
		int opcao = sc.nextInt();
		sc.nextLine();

		switch (opcao) {
			case 1:
				escolherUF(sc);
				break;
			case 2:
				escolherRegiao(sc);
				break;
			default:
				System.out.println("Opção inválida.");
		}

		sc.close();
	}

	private static void escolherUF(Scanner sc) {
		System.out.println("Escolha uma UF (sigla):");
		for (UF uf : UF.values()) {
			System.out.print(uf.name() + " ");
		}
		System.out.println();

		String ufEscolhida = sc.nextLine().toUpperCase();

		if (UF.validarSigla(ufEscolhida)) {
			UF uf = UF.valueOf(ufEscolhida);
			System.out.println("Você escolheu: " + uf.getNomePorExtenso());
		} else {
			System.out.println("Sigla de UF inválida.");
		}
	}

	private static void escolherRegiao(Scanner sc) {
		System.out.println("Escolha uma Região:");
		for (Regiao regiao : Regiao.values()) {
			System.out.print(regiao.name() + " ");
		}
		System.out.println();

		String regiaoEscolhida = sc.nextLine().toUpperCase();

		Regiao regiao = obterRegiaoPorSigla(regiaoEscolhida);
		if (regiao != null) {
			System.out.println("Estados da região " + regiao.name() + ":");
			UF.escreverEstadosPorRegiao(regiao);
		} else {
			System.out.println("Região inválida.");
		}
	}

	// Método para obter a Regiao a partir da sigla
	private static Regiao obterRegiaoPorSigla(String sigla) {
		for (Regiao regiao : Regiao.values()) {
			if (regiao.name().equals(sigla)) {
				return regiao;
			}
		}
		return null;
	}

	static void limpa() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else if (System.getProperty("os.name").contains("Linux")
					|| System.getProperty("os.name").contains("Mac")) {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			} else {
				System.out.println("Este comando não funciona no seu sistema operacional.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
