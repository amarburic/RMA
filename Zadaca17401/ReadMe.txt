+++++ Amar Buric
+++++ 17401
+++++ 2016/17
+++++ RMA
+++++
+++++ Spirala 1
+++++ Uradjeno: 
+++++ Uradjena su sva cetiri zadatka u potpunosti 
+++++ Nije uradjeno:
+++++ -
+++++
+++++ Spirala 2
+++++ Uradjeno: 
+++++ Uradjeno su svi zadaci, s tim da, kad je u pitanju lokalizacija, prevedeni su 
+++++ samo stringovi koji su se nalazili u values folderu (natpisi na buttonima i naziv spola)
+++++ Podaci koji ce se eventualno preuzimati iz baze, tipa nazivi zanrova, biografije glumaca i slicno
+++++ nisu prevodjeni, jer nisam mislio da je potrebno. 
+++++ Imao sam nedoumice oko toga da li je potrebno spasavati stanje izmedju koristenja razlicith layouta
+++++ ali sam, prema savjetu demonstratora, namjestio da prelazak u landscape mode uvijek vodi ka listi glumaca
+++++ i detaljima o prvom glumcu, bez obzira na trenutno otvoreni fragment u portrait modeu. 
+++++ Ako sam dobro razumio, jedinu transakciju koju je potrebo staviti na back stack je izmjenu fragmenta
+++++ liste glumaca sa fragmentom detalja o glumcu. Back button na svim ostalim fragmentima gasi aplikaciju.
+++++ S obzirom da nije naglaseno drugacije, nisam slao citave klase fragmentima implementirajuci Parcelable interfejs.
+++++ Svi podaci su staticki u zasebnoj klasi kojoj fragmenti imaju pristup, a jedina informacija koja se salje izmedju 
+++++ liste glumaca, glavne aktivnosti i detalja o glumcu jeste indeks kliknutog elementa. 
+++++ Nije uradjeno:
+++++ -
+++++ Spirala 3
+++++ Uradjeno: 
+++++ Uradjeni su svi zadaci. Par napomena: postoji par primjecenih problema 
+++++ sa apijem, gdje neki stringovi vracaju 500 response. Takodjer, ima pogrešnih informacija
+++++ kad je spol u pitanju (dosta requestova vraca gender 0 za osobe koje su otvoreno cissexualne)
+++++ Posto u bazi nema slika za zanrove prikazuje se no image oznaka.
+++++ -
+++++ Naknadna napomena: Funkcionalnosti koje su radile u vremenu kada je poslana spirala
+++++ su prestale raditi nakon nekog vremena zbog nekih izmjena u samom web servisu.
+++++ Problem je u tome što je promijenjen naèin na koji se vraæaju null vrijednosti, što je uzrok toga da se ne fetchaju kako treba
+++++ svi glumci prilikom searcha. U sklopu 4. spirale je dodana izmjena kako bi search ponovo bio funkcionalan.
+++++ -
+++++ Spirala 4
+++++ Uraðene sve stavke u potpunosti osim 4. c. Dodan je kod koji traži permisije, kod koji querya
+++++ kako bi provjerio da li postoji kalendar i dodaje novi ako je to potrebno, zatim nalazi id kalendara
+++++ i dodaje event. Meðutim, iako se sav kod izvrši, event iz nekog razloga, nije i dalje vidljiv na kalendaru.
+++++ Kod je pisan po uzoru na tutorijal linkan u tekstu spirale.
+++++ Dodatak: Zadatak je na kraju uraðen korištenjem intentova.

++++ Napomena: Aplikacija je testirana na LG G3 sa Lollipop verzijom Androida.