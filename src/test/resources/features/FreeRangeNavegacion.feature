@navigation @smoke
Feature: Navigation

  As a user without logging in on the FRT webpage
  I want to navigate through the sections
  So that I can see the content of the site

  Background: The user is on the Free Range Testers web without logging in.
    Given The user navigate to www.freerangetesters.com

@smoke @QaseId=2
  Scenario Outline: The user can access the subpages through the navigation bar
    When The user clicks on the section <Section Name>
    Then The <Section Name> corresponds to <Section url>

     Examples: Navigation Data
      | Section Name  | Section url                                |
      | Suscripciones | freerangetesters.com/suscripciones         |
      | Cursos        | freerangetesters.com/cursos                |
      | Mentorías     | freerangetesters.com/mentoria-1-1-con-pato |
      | Talleres      | freerangetesters.com/talleres-y-webinars   |
      | Blog          | freerangetesters.com/blog                  |
      | Recursos      | freerangetesters.com/recursos              |
      | Acceder       | freerangetesters.com/login                 |


@login @smoke @QaseId=3
  Scenario: Login
   Given the user is on Acceder Section
   When the user enters an incorrect email
   And the user waits to "Operación exitosa" message to appear
   And the user clicks on Inicio de sesion button
   Then the message: "Incluye un signo @ en la dirección de correo electrónico", must appear

  

  








