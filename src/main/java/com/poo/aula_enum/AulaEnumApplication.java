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

		System.out.println("Escolha uma UF (sigla): ");
		for (UF uf : UF.values()) {
			System.out.print(uf.name() + " ");
		}
		System.out.println();

		String ufEscolhida = sc.nextLine().toUpperCase();

		if (UF.validarSigla(ufEscolhida)) {
            UF uf = UF.valueOf(ufEscolhida);
            System.out.println("A UF escolhida foi: " + uf.getNomePorExtenso());
        } else {
            System.out.println("Sigla de UF inválida.");
        }

		sc.close();
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
