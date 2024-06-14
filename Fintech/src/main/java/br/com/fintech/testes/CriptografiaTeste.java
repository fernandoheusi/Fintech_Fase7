package br.com.fintech.testes;


import br.com.fintech.utils.CriptografiaUtils;

public class CriptografiaTeste {
	
	public static void main(String[] args) {
		try {
			System.out.println(CriptografiaUtils.criptografar("30214950"));
			System.out.println(CriptografiaUtils.criptografar("30214950"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
