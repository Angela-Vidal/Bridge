public class Main {

    //implementação do metodo bridge
    interface Canal {
        void enviar(String texto);

    }
    //implementação do envio de mensagem por e-mail
    static class Email implements Canal {
        public void enviar(String texto) {
            System.out.println("📧 Enviando por E-MAIL: " + texto);
        }
    }
    //implementação do envio de mensagem via sms
    static class SMS implements Canal {
        public void enviar(String texto) {
            System.out.println("📱 Enviando por SMS: " + texto);
        }
    }
    // abstração: mensagem
    static class Mensagem {
        private Canal canal;

        public Mensagem(Canal canal) {
            this.canal = canal;
        }

        public void enviarMensagem(String texto) {
            canal.enviar(texto);
        }
    }
    //metodo principal
    public static void main(String[] args) {
        Mensagem mensagemSMS = new Mensagem(new SMS());
        mensagemSMS.enviarMensagem("Mensagem de alerta: Verifique seu sistema.");

        System.out.println("---");

        Mensagem mensagemEmail = new Mensagem(new Email());
        mensagemEmail.enviarMensagem("Mensagem comum: Bem-vindo à nossa plataforma!");
    }
}
