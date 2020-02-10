package br.com.rsi_hub.appium.utilitarios;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MassaDeDados {	

	
	public String digiteNome() throws Exception {
		UtilitarioExcel.setExcelFile("C:\\Users\\carlos.silva\\Desktop\\DadosExcel.xlsx","Planilha1");
		String nome = UtilitarioExcel.getCellData(1, 0);
		return nome;
	}
	
	public String digiteEmail() throws Exception {
		String email = UtilitarioExcel.getCellData(1, 1);
		return email;
	}
	
	public String digiteSenha() throws Exception {
		String senha = UtilitarioExcel.getCellData(1, 2);
		return senha;
	}
	
	public String confirmarSenha() throws Exception {
		String confirmeSenha = UtilitarioExcel.getCellData(1, 3);
		return confirmeSenha;
	}
	
	public String digitePrimeiroNome() throws Exception {
		String primeiroNome = UtilitarioExcel.getCellData(1, 4);
		return primeiroNome;
	}
	
	public String digiteUltimoNome() throws Exception {
		String ultimoNome = UtilitarioExcel.getCellData(1, 5);
		return ultimoNome;
	}
	
	public String digiteTelefone() throws Exception {
		String telefone = UtilitarioExcel.getCellData(1, 6);
		return telefone;
	}
	
	public String escolhaPais() throws Exception {
		String pais = UtilitarioExcel.getCellData(1, 7);
		return pais;
	}
	
	public String digiteEstado() throws Exception {
		String estado = UtilitarioExcel.getCellData(1, 8);
		return estado;
	}
	
	public String digiteEndereco() throws Exception {
		String endereco = UtilitarioExcel.getCellData(1, 9);
		return endereco;
	}
	
	public String digiteCidade() throws Exception {
		String cidade = UtilitarioExcel.getCellData(1, 10);
		return cidade;
	}
	
	public String digiteCep() throws Exception {
		String cep = UtilitarioExcel.getCellData(1, 11);
		return cep;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
