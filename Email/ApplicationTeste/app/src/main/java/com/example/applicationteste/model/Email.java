package com.example.applicationteste.model;

public class Email {
    private String usuario;
    private String assunto;
    private String preview;
    private String date;
    private boolean stared;
    private boolean unread;
    private boolean selected;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static class EmailBuilder{
        private String usuario;
        private String assunto;
        private String preview;
        private String date;
        private boolean stared;
        private boolean unread;
        private boolean selected;

        //retorna um do tipoEmailBuilder, para quando chamarmos emm AllEmails, nós apenas adicionamos
        //o ponto "." e continuamos adicionando
        public EmailBuilder setSelected(boolean selected) {
            this.selected = selected;
            return this;
        }

        public EmailBuilder setUnread(boolean unread) {
            this.unread = unread;
            return this;
        }

        public EmailBuilder setStared(boolean stared) {
            this.stared = stared;
            return this;
        }

        public EmailBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public EmailBuilder setPreview(String preview) {
            this.preview = preview;
            return this;
        }

        public EmailBuilder setAssunto(String assunto) {
            this.assunto = assunto;
            return this;
        }

        public EmailBuilder setUsuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        private EmailBuilder(){}
        public static EmailBuilder builder(){

            return new EmailBuilder();
        }

        public Email build(){
            Email email = new Email();
            email.usuario = usuario;
            email.assunto = assunto;
            email.date = date;
            email.preview = preview;
            email.stared = stared;
            email.selected = selected;
            email.unread = unread;

            return email;
        }
    }

}
