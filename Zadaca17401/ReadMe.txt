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

++++ Napomena: Aplikacija je testirana na LG G3 sa Lollipop verzijom Androida.