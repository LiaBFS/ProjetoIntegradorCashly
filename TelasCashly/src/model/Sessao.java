package model;

	public class Sessao {
	    private static Usuario usuarioLogado;

	    public static void setUsuarioLogado(Usuario usuario) {
	        usuarioLogado = usuario;
	    }

	    public static Usuario getUsuarioLogado() {
	        return usuarioLogado;
	    }
	}

