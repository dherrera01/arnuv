package com.core.arnuv.services.imp;

import jakarta.mail.MessagingException;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmail {

    @Value("${spring.mail.username}")
    private String emailarnuv;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String content) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

        mailSender.send(email);
    }

//  Tutorial del servidor de email
//    https://pabasararathnayake.medium.com/spring-boot-application-to-send-emails-using-smtp-protocol-c2616d7edf92
    public void sendEmailNuevoUsuario(String to, String token, String password, String nombrecompleto) throws MessagingException {

        MimeMessage email = mailSender.createMimeMessage();
        String url = "https://vinculacion-production.up.railway.app";
        
        email.setFrom(new InternetAddress(emailarnuv));
        email.setRecipients(MimeMessage.RecipientType.TO, to);
        email.setSubject("CONFIRMACIÓN DE CUENTA EN ARNUV");
        String htmlTemplate = themplateMailConfirmacion;
        htmlTemplate = htmlTemplate.replace("${nombrecompleto}", nombrecompleto);
        htmlTemplate = htmlTemplate.replace("${link}", url + "/#/confirmacion?token=${token}");
        htmlTemplate = htmlTemplate.replace("${token}", token);
        htmlTemplate = htmlTemplate.replace("${texto}", "Por favor confirma tu cuenta y cambia tu contraseña para continuar. Tu contraseña temporal es: <h3>${password}</h3>");
        htmlTemplate = htmlTemplate.replace("${password}", password);
        email.setContent(htmlTemplate,  "text/html; charset=utf-8");

        mailSender.send(email);
    }

    private String themplateMailConfirmacion = "<!DOCTYPE HTML\n" +
            "  PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
            "  xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
            "\n" +
            "<head>\n" +
            "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "  <title></title>\n" +
            "\n" +
            "  <style type=\"text/css\">\n" +
            "    @media only screen and (min-width: 620px) {\n" +
            "      .u-row {\n" +
            "        width: 600px !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-row .u-col {\n" +
            "        vertical-align: top;\n" +
            "      }\n" +
            "\n" +
            "      .u-row .u-col-33p33 {\n" +
            "        width: 199.98px !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-row .u-col-47p17 {\n" +
            "        width: 283.02px !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-row .u-col-50 {\n" +
            "        width: 300px !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-row .u-col-52p83 {\n" +
            "        width: 316.98px !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-row .u-col-100 {\n" +
            "        width: 600px !important;\n" +
            "      }\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "    @media (max-width: 620px) {\n" +
            "      .u-row-container {\n" +
            "        max-width: 100% !important;\n" +
            "        padding-left: 0px !important;\n" +
            "        padding-right: 0px !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-row .u-col {\n" +
            "        min-width: 320px !important;\n" +
            "        max-width: 100% !important;\n" +
            "        display: block !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-row {\n" +
            "        width: 100% !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-col {\n" +
            "        width: 100% !important;\n" +
            "      }\n" +
            "\n" +
            "      .u-col>div {\n" +
            "        margin: 0 auto;\n" +
            "      }\n" +
            "    }\n" +
            "\n" +
            "    body {\n" +
            "      margin: 0;\n" +
            "      padding: 0;\n" +
            "    }\n" +
            "\n" +
            "    table,\n" +
            "    tr,\n" +
            "    td {\n" +
            "      vertical-align: top;\n" +
            "      border-collapse: collapse;\n" +
            "    }\n" +
            "\n" +
            "    p {\n" +
            "      margin: 0;\n" +
            "    }\n" +
            "\n" +
            "    .ie-container table,\n" +
            "    .mso-container table {\n" +
            "      table-layout: fixed;\n" +
            "    }\n" +
            "\n" +
            "    * {\n" +
            "      line-height: inherit;\n" +
            "    }\n" +
            "\n" +
            "    a[x-apple-data-detectors='true'] {\n" +
            "      color: inherit !important;\n" +
            "      text-decoration: none !important;\n" +
            "    }\n" +
            "\n" +
            "    table,\n" +
            "    td {\n" +
            "      color: #000000;\n" +
            "    }\n" +
            "\n" +
            "    #u_body a {\n" +
            "      color: #0000ee;\n" +
            "      text-decoration: underline;\n" +
            "    }\n" +
            "\n" +
            "    @media (max-width: 480px) {\n" +
            "      #u_content_image_1 .v-src-width {\n" +
            "        width: auto !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_1 .v-src-max-width {\n" +
            "        max-width: 40% !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_heading_1 .v-font-size {\n" +
            "        font-size: 38px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_3 .v-src-width {\n" +
            "        width: 100% !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_3 .v-src-max-width {\n" +
            "        max-width: 100% !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_text_5 .v-container-padding-padding {\n" +
            "        padding: 10px 30px 11px 10px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_text_3 .v-container-padding-padding {\n" +
            "        padding: 15px 10px 20px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_13 .v-src-width {\n" +
            "        width: auto !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_13 .v-src-max-width {\n" +
            "        max-width: 29% !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_15 .v-container-padding-padding {\n" +
            "        padding: 27px 10px 10px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_15 .v-src-width {\n" +
            "        width: auto !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_15 .v-src-max-width {\n" +
            "        max-width: 29% !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_16 .v-container-padding-padding {\n" +
            "        padding: 22px 10px 10px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_16 .v-src-width {\n" +
            "        width: auto !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_image_16 .v-src-max-width {\n" +
            "        max-width: 29% !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_heading_3 .v-container-padding-padding {\n" +
            "        padding: 20px 10px 0px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_heading_3 .v-text-align {\n" +
            "        text-align: center !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_text_9 .v-container-padding-padding {\n" +
            "        padding: 10px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_text_9 .v-text-align {\n" +
            "        text-align: center !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_button_1 .v-container-padding-padding {\n" +
            "        padding: 15px 10px 50px !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_button_1 .v-text-align {\n" +
            "        text-align: center !important;\n" +
            "      }\n" +
            "\n" +
            "      #u_content_button_1 .v-padding {\n" +
            "        padding: 13px 30px 12px !important;\n" +
            "      }\n" +
            "    }\n" +
            "  </style>\n" +
            "\n" +
            "  <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\">\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body class=\"clean-body u_body\"\n" +
            "  style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #536068;color: #000000\">\n" +
            "  <table id=\"u_body\"\n" +
            "    style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #536068;width:100%\"\n" +
            "    cellpadding=\"0\" cellspacing=\"0\">\n" +
            "    <tbody>\n" +
            "      <tr style=\"vertical-align: top\">\n" +
            "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
            "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
            "            <div class=\"u-row\"\n" +
            "              style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #fbfcff;\">\n" +
            "              <div\n" +
            "                style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
            "                <div class=\"u-col u-col-100\"\n" +
            "                  style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
            "                  <div\n" +
            "                    style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "                    <div\n" +
            "                      style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "                      <table id=\"u_content_heading_1\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\"\n" +
            "                        cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "                        <tbody>\n" +
            "                          <tr>\n" +
            "                            <td class=\"v-container-padding-padding\"\n" +
            "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 10px 30px;font-family:'Montserrat',sans-serif;\"\n" +
            "                              align=\"left\">\n" +
            "                              <h1 class=\"v-text-align v-font-size\"\n" +
            "                                style=\"margin: 0px; color: #27187e; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Montserrat',sans-serif; font-size: 36px; font-weight: 400;\">\n" +
            "                                <strong>Verificación de Cuenta</strong></h1>\n" +
            "                            </td>\n" +
            "                          </tr>\n" +
            "                        </tbody>\n" +
            "                      </table>\n" +
            "                    </div>\n" +
            "                  </div>\n" +
            "                </div>\n" +
            "              </div>\n" +
            "            </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
            "            <div class=\"u-row\"\n" +
            "              style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
            "              <div\n" +
            "                style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
            "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
            "                  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "                    <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "                      <table id=\"u_content_text_5\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\"\n" +
            "                        cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "                        <tbody>\n" +
            "                          <tr>\n" +
            "                            <td class=\"v-container-padding-padding\"\n" +
            "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 30px 20px 40px;font-family:'Montserrat',sans-serif;\"\n" +
            "                              align=\"left\">\n" +
            "\n" +
            "                              <div class=\"v-text-align v-font-size\"\n" +
            "                                style=\"font-size: 14px; color: #4b4a4a; line-height: 190%; text-align: left; word-wrap: break-word;\">\n" +
            "                                <p style=\"font-size: 14px; line-height: 190%;\"><span\n" +
            "                                    style=\"font-size: 18px; line-height: 34.2px;\"><strong><span\n" +
            "                                        style=\"line-height: 34.2px; font-size: 18px;\">Saludos ${nombrecompleto}</span></strong></span></p>\n" +
            "                                <p style=\"font-size: 14px; line-height: 190%;\"><span\n" +
            "                                    style=\"font-size: 16px; line-height: 30.4px;\">${texto}</span></p>\n" +
            "                              </div>\n" +
            "\n" +
            "                            </td>\n" +
            "                          </tr>\n" +
            "                        </tbody>\n" +
            "                      </table>\n" +
            "                    </div>\n" +
            "                  </div>\n" +
            "                </div>\n" +
            "              </div>\n" +
            "            </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
            "            <div class=\"u-row\"\n" +
            "              style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
            "              <div\n" +
            "                style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
            "                <div class=\"u-col u-col-50\"\n" +
            "                  style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
            "                  <div\n" +
            "                    style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "                    <div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
            "                      <table id=\"u_content_text_3\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\"\n" +
            "                        cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "                        <tbody>\n" +
            "                          <tr>\n" +
            "                            <td class=\"v-container-padding-padding\"\n" +
            "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Montserrat',sans-serif;\"\n" +
            "                              align=\"left\">\n" +
            "\n" +
            "                            </td>\n" +
            "                          </tr>\n" +
            "                        </tbody>\n" +
            "                      </table>\n" +
            "\n" +
            "                      <table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\"\n" +
            "                        cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "                        <tbody>\n" +
            "                          <tr>\n" +
            "                            <td class=\"v-container-padding-padding\"\n" +
            "                              style=\"overflow-wrap:break-word;word-break:break-word;padding:15px 10px 30px;font-family:'Montserrat',sans-serif;\"\n" +
            "                              align=\"left\">\n" +
            "                              <div class=\"v-text-align\" align=\"center\">\n" +
            "                                <a href=\"${link}\" target=\"_blank\" class=\"v-button v-font-size\"\n" +
            "                                  style=\"box-sizing: border-box;display: inline-block;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #ff8600; border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px; width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;font-size: 14px;\">\n" +
            "                                  <span class=\"v-padding\"\n" +
            "                                    style=\"display:block;padding:16px 50px;line-height:120%;\"><strong><span\n" +
            "                                        style=\"font-size: 14px; line-height: 16.8px;\">CAMBIAR CONTRASEÑA</span></strong></span>\n" +
            "                                </a>\n" +
            "                              </div>\n" +
            "                            </td>\n" +
            "                          </tr>\n" +
            "                        </tbody>\n" +
            "                      </table>\n" +
            "                    </div>\n" +
            "                  </div>\n" +
            "                </div>\n" +
            "              </div>\n" +
            "            </div>\n" +
            "            \n" +
            "        </td>\n" +
            "      </tr>\n" +
            "    </tbody>\n" +
            "  </table>\n" +
            "</body>\n" +
            "\n" +
            "</html>";

}
