package TesteSeguranca;

import Controller.Seguranca;

public class TesteMD5 {
    public static void main(String[] args) {
        String senha = "123456";
        System.out.println("Senha: " + senha);
        String hash = Seguranca.Hash(senha,16);
        
        System.out.println("Hash: " + hash);
        String cod = Seguranca.Codificar(senha);
        System.out.println("Codificada: " + cod);
        System.out.println("Tamanho: " + cod.length());
    }
}
