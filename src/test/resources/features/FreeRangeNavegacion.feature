@Navigation
Feature: Navigation

  As a user without logging in on the FRT webpage
  I want to navigate through the sections
  So that I can see the content of the site

  Background: The user is on the Free Range Testers web without logging in.
    Given The user navigate to www.freerangetesters.com

  @QaseId=2
  Scenario Outline: The user can access the subpages through the navigation bar
    When The user clicks on the section <Section Name>
    Then The <Section Name> corresponds to <Section url>

     Examples: Navigation Data
      | Section Name | Section url|
       | Academia     | freerangetesters.com/academia|
       | Cursos       | freerangetesters.com/cursos|
       | Mentorías    | freerangetesters.com/mentoria-1-1-con-pato|
       | Talleres     | freerangetesters.com/talleres-y-webinars|
       | Blog         | freerangetesters.com/blog|
       | Recursos     | freerangetesters.com/recursos|
       | Udemy        | freerangetesters.com/udemy|
       | Acceder      | freerangetesters.com/login|


@Login
  Scenario: Profile webpage- Login
   Given the user is on Acceder Section
   When the user enters an incorrect email
   And clicks on Inicio de sesion button
   Then the message: "Incluye un signo @ en la dirección de correo electrónico", must appear

  

  








