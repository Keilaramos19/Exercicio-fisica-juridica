package app;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import entities.Contribuinte;
import entities.Empresa;
import entities.Individual;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		List<Contribuinte> list=new ArrayList<>();
		
		System.out.print("Digitar o número de Contribuintes");
		int n=sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Contribuinte#"+i+"Dados:");
			System.out.print("Individual ou empresa (i/e)?");
			char type= sc.next().charAt(0);
			System.out.print("Nome:");
			sc.nextLine();
			String nome =sc.nextLine();
			System.out.print("Renda Anual:");
			double renda=sc.nextDouble();
			if(type=='i') {
				System.out.print("Despesas com saúde:");
				double despesasComSaude=sc.nextDouble();
				list.add(new Individual(nome,renda,despesasComSaude));
				}
			else {
				System.out.print("Número de Funcionarios:");
				int numeroDeFuncionarios=sc.nextInt();
				list.add(new Empresa(nome,renda,numeroDeFuncionarios));
					
				}
			
		}
		double sum=0.0;
		System.out.println();
		System.out.println("Impostos Pagos:");
		for(Contribuinte  c:list) {
			double imposto=c.imposto();
			System.out.println(c.getNome()+":$"+String.format("%.2f",imposto));
			sum+=imposto;
		}
		System.out.println();
		System.out.println("Imposto totais:$"+String.format("%.2f",sum));
		
		sc.close();
		
		
	}
}
