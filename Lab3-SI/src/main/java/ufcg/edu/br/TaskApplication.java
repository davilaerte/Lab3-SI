package ufcg.edu.br;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ufcg.edu.br.dados.ListaDeTarefaRepository;
import ufcg.edu.br.dados.model.ListaDeTarefas;
import ufcg.edu.br.dados.model.SubTarefa;
import ufcg.edu.br.dados.model.Tarefa;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	//iniciliza Atividades Default.
	@Bean
	public CommandLineRunner initializeDb(ListaDeTarefaRepository repository){
	   return (args) -> {
	        
		   	 
		   	 for (int i = 1; i <= 15; i++) {	
		   		ListaDeTarefas lista = new ListaDeTarefas("Lista Teste "+i);
		   		
		   		Tarefa tarefa = new Tarefa("Limpar o Quarto "+i,"Limpeza","Fazer antes das 3h","Alta",false);
				Tarefa tarefa2 = new Tarefa("Estudar Para Fisica "+i,"Estudos","","Alta",false);
				Tarefa tarefa3 = new Tarefa("Fazer Almoco "+i,"Casa","...","Media",false);
				Tarefa tarefa4 = new Tarefa("Limpar a sala "+i,"Limpeza","","Baixa",false);
				   	
				tarefa.addSubTarefa(new SubTarefa("Arrumar Guarda-Roupa", false));
				   	
				lista.addTarefa(tarefa);
				lista.addTarefa(tarefa2);
				lista.addTarefa(tarefa3);
				lista.addTarefa(tarefa4);

				repository.save(lista);
		   	 }
		   
		};
	}
}
