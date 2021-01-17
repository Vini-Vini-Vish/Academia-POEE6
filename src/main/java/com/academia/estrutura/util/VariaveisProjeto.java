package com.academia.estrutura.util;

import java.util.Objects;

public class VariaveisProjeto {
	
	public static final String PERSISTENCE_UNIT_NAME = "projeto";
	
	//-------------------------------------------------------------------
	
	public static final Integer INCLUSAO = 1;
	public static final Integer ALTERACAO = 2;
	public static final Integer EXCLUSAO = 3;
	public static final Integer CONSULTA = 4;
		
	//-------------------------------------------------------------------
	
	public static final Integer ERRO_INCLUSAO = 10;
	public static final Integer ERRO_ALTERACAO = 20;
	public static final Integer ERRO_EXCLUSAO = 30;
	
	//-------------------------------------------------------------------
	
	public static final Integer INCLUSAO_REALIZADA = 1;
	public static final Integer	ALTERACAO_REALIZADA = 2;
	public static final Integer EXCLUSAO_REALIZADA = 3;
	
	//-------------------------------------------------------------------
	
	public static final Integer DIGITACAO_OK = 100;
	
	//-------------------------------------------------------------------
	
	//Usuario
	public static final Integer USUARIO_USER_NAME = 201;
	public static final Integer USUARIO_EMAIL = 202;
	public static final Integer USUARIO_PASSWORD = 203;
	
	//-------------------------------------------------------------------
	
	//Departamento
	public static final Integer DEPARTAMENTO_NOME = 300;
	
	//-------------------------------------------------------------------
	
	//Aluno //Personal //Atividade
	public static final Integer DESCRICAO = 400;
	public static final Integer NOME = 401;
	public static final Integer GENERO = 402;
	public static final Integer IDADE = 403;
	public static final Integer ENDERECO = 404;
	public static final Integer NUMERO = 405;
	public static final Integer BAIRRO = 406;
	public static final Integer CIDADE = 407;
	public static final Integer TELEFONE = 408;
	public static final Integer CODIGO_POSTAL = 409;
	public static final Integer PERIODO = 410;
	public static final Integer CREF = 411;
	
	//-------------------------------------------------------------------
		
	public static final String LIMPA_CAMPO = "";
	
	//-------------------------------------------------------------------
	
	public static boolean digitacaoCampo(Integer texto) {
		if(Objects.isNull(texto)) {
			return true;
		}		
		
		if("".equals(String.valueOf(texto))) {
			return true;
		}
		
		return false;
	}
	
	//-------------------------------------------------------------------
	
	public static boolean digitacaoCampo(String texto) {
		if(Objects.isNull(texto)) {
			return true;
		}
		
		if("".equals(texto.trim())) {
			return true;
		}
		
		return false;
	}

	//-------------------------------------------------------------------
	
	public static Integer convertToInteger(String text) {
		return Integer.parseInt(text);
	}
	
}
