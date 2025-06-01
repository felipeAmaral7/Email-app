package com.example.applicationteste.model;

import java.util.Arrays;
import java.util.List;

public class AllEmails {

    public static List<Email> fakeEmails(){
        return Arrays.asList(
                Email.EmailBuilder.builder()
                        .setUsuario("Facebook")
                        .setAssunto("Asunto legal para voce ver todos os dias")
                        .setPreview("Preview muito legal para voce entender melhor recyclerview")
                        .setDate("30 abril")
                        .setStared(true)
                        .setUnread(true)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Instagram")
                        .setAssunto("Você tem novas curtidas na sua foto")
                        .setPreview("Veja quem interagiu com sua postagem mais recente")
                        .setDate("1 maio")
                        .setStared(true)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("LinkedIn")
                        .setAssunto("Novas oportunidades para sua carreira")
                        .setPreview("Empresas estão visualizando seu perfil")
                        .setDate("29 abril")
                        .setStared(false)
                        .setUnread(true)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("GitHub")
                        .setAssunto("Atualizações em repositórios que você segue")
                        .setPreview("Alguém fez um push recente no seu projeto favorito")
                        .setDate("28 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Spotify")
                        .setAssunto("Sua playlist da semana está pronta")
                        .setPreview("Descubra músicas novas baseadas no seu gosto")
                        .setDate("27 abril")
                        .setStared(true)
                        .setUnread(true)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Google")
                        .setAssunto("Alerta de segurança na sua conta")
                        .setPreview("Detectamos uma tentativa de login suspeita")
                        .setDate("26 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Amazon")
                        .setAssunto("Seu pedido foi enviado!")
                        .setPreview("Rastreie sua encomenda e veja a previsão de entrega")
                        .setDate("24 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Banco do Brasil")
                        .setAssunto("Extrato mensal disponível")
                        .setPreview("Acesse seu app para ver o resumo financeiro de abril")
                        .setDate("23 abril")
                        .setStared(true)
                        .setUnread(false)
                        .setSelected(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Coursera")
                        .setAssunto("Novo curso recomendado para você")
                        .setPreview("Aprenda sobre inteligência artificial com especialistas")
                        .setDate("22 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Twitter")
                        .setAssunto("Veja o que está bombando agora")
                        .setPreview("Confira os trending topics do momento")
                        .setDate("21 abril")
                        .setStared(true)
                        .setUnread(true)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Udemy")
                        .setAssunto("Oferta especial para você")
                        .setPreview("Cursos com até 90% de desconto, só hoje")
                        .setDate("20 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Dropbox")
                        .setAssunto("Seu espaço está quase cheio")
                        .setPreview("Libere espaço ou faça upgrade para continuar salvando arquivos")
                        .setDate("19 abril")
                        .setStared(true)
                        .setUnread(true)
                        .setSelected(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Mercado Livre")
                        .setAssunto("Temos recomendações pra você")
                        .setPreview("Baseado em suas últimas buscas, veja essas ofertas")
                        .setDate("18 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Steam")
                        .setAssunto("Promoção de jogos da semana")
                        .setPreview("Aproveite descontos em títulos populares e indies")
                        .setDate("17 abril")
                        .setStared(true)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Airbnb")
                        .setAssunto("Planeje sua próxima viagem")
                        .setPreview("Encontre hospedagens incríveis para sua próxima aventura")
                        .setDate("16 abril")
                        .setStared(false)
                        .setUnread(true)
                        .setSelected(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("GloboPlay")
                        .setAssunto("Nova série exclusiva disponível")
                        .setPreview("Assista agora ao primeiro episódio sem custo")
                        .setDate("15 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("iFood")
                        .setAssunto("Cupom de desconto liberado")
                        .setPreview("Use o cupom IFOME10 no seu próximo pedido")
                        .setDate("14 abril")
                        .setStared(true)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("WhatsApp")
                        .setAssunto("Backup concluído com sucesso")
                        .setPreview("Seu histórico de conversas foi salvo no Google Drive")
                        .setDate("13 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("PagSeguro")
                        .setAssunto("Você recebeu um pagamento")
                        .setPreview("Confira os detalhes da transação no app")
                        .setDate("12 abril")
                        .setStared(false)
                        .setUnread(false)
                        .setSelected(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUsuario("Telegram")
                        .setAssunto("Novas atualizações disponíveis")
                        .setPreview("Explore os novos recursos adicionados no app")
                        .setDate("11 abril")
                        .setStared(true)
                        .setUnread(false)
                        .setSelected(false)
                        .build());
    }
}