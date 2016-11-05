package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Seguranca {

    private static MessageDigest md = null;

    //Instanciando o Objeto md
    static {
        try {
            md = MessageDigest.getInstance("MD5");
            //md = MessageDigest.getInstance("SHA-1");
            //md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    //Codificar a senha
    public static String Codificar(String senha) {
        String novaSenha = "";
        byte[] bSenha = senha.getBytes();   //retornar o byte da string
        senha = Arrays.toString(bSenha); //transforma a senha em um vetor de bytes
        
        //System.out.println("Byte: " + senha);
        //System.out.println("Lenght: " + bSenha.length);
        
        //recria diversos Hash com base na novasenha e o indice i
        for (int i = 8; i <= bSenha.length * 2; i++) {
            novaSenha += Hash(senha, i);
            //System.out.println("Codificando ("+i+"): " + novaSenha);
        }
        
        //System.out.println("Lenght: " + novaSenha.length());
        //a nova senha recebe por fim um hash final de 128 bits ((16 ^ 2) / 2)
        novaSenha = Hash(novaSenha, 16);
        return novaSenha;
    }

    public static String Hash(String senha, int bit) {
        if (md != null) {
            //Vetor de Bytes, Ponto de Inicio, Tamanho
            md.update(senha.getBytes(), 0, senha.length());
            //Retorna uma string de 128 bits ((16 ^ 2) / 2) da conversão de 
            //um Inteiro com tamanho de 1 ^ ((10 ^ 8) * 5)
            //transformando o codigo Hash retornado do metodo digest()
            return new BigInteger(1, md.digest()).toString(bit);
        }
        return "";
    } 
}
