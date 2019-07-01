# java_project

01.07.2019
To do:

(Problem: chciałem żebyśmy zrobili LoginPanel, ale wtedy GuestPanel i UserPanel się nie różnią - może lepiej zrobić bez LoginPanel?)

MainWindow:
  Zaimplementować metodę zmieniającą aktywny panel
  (Panele: LoginPanel, UserPanel, GuestPanel)
  
BasePanel:
  Obsługa przycisków we współpracy z fasadą:
  - Następny przepis
  - Poprzedni przepis
  - Wyszukaj przepis
  - Filtruj wyszukiwanie
  
GuestPanel:
  Obsługa przycisków we współpracy z fasadą:
  - Logowanie użytkownika
  
UserPanel:
  Obsługa przycisków we współpracy z fasadą:
  - Dodawanie przepisu
  - accept_recipe_button?
  - Wyglogowanie użytkownika
  
Fasada:
  Zaimplementować metody potrzebne dla Paneli:
  - Wczytywanie kolejnego przepisu 
  (zwraca przepis w stringu; [0]-tresc, [1]-skladniki)
  - Wczytywanie poprzedniego przepisu
  (zwraca przepis w stringu; [0]-tresc, [1]-skladniki)
  - Znajdywanie dopasowania
  (może zwracać tytuły, najlepiej listę par <id, tytuł>, które pasują)
  - Zmiana filtru wyszukiwania
  (setter jakiegoś pola "filter" - z tego pola korzysta powyższa metoda)
  
  
