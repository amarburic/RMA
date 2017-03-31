package ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke;

import java.util.ArrayList;
import java.util.List;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Glumac;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Osoba;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Reziser;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Zanr;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;

/**
 * Created by Amar.B on 28.03.2017..
 */

public class Podaci {
    private static final Podaci ourInstance = new Podaci();

    static Podaci getInstance() {
        return ourInstance;
    }

    private Podaci() {
    }

    static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex" +
            " ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
            "cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, " +
            "sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static List<Glumac> glumci = new ArrayList<Glumac>();
    public static List<Reziser> reziseri = new ArrayList<Reziser>();
    public static List<Zanr> zanrovi = new ArrayList<Zanr>();
    static
    {
        glumci.add(new Glumac(R.drawable.audrey_hepburn, "Audrey", "Hepburn", 1929, 1993,
                "Belgium", Osoba.Spol.Z, loremIpsum, 9, 30));
        glumci.add(new Glumac(R.drawable.gregory_peck, "Gregory", "Peck", 1916, 2003,
                "California", Osoba.Spol.M, loremIpsum, 9, 60));
        glumci.add(new Glumac(R.drawable.diane_keaton, "Diane", "Keaton", 1946, -1,
                "Los Angeles", Osoba.Spol.Z, loremIpsum, 10, 473));
        glumci.add(new Glumac(R.drawable.woody_allen, "Woody", "Allen", 1935, -1,
                "New York", Osoba.Spol.M, loremIpsum, 10, 95));
        glumci.add(new Glumac(R.drawable.ingrid_bergman, "Ingrid", "Bergman", 1915, 1982,
                "Stockholm", Osoba.Spol.Z, loremIpsum, 9, 6));
        glumci.add(new Glumac(R.drawable.humphrey_bogart, "Humphrey", "Bogart", 1899, 1957,
                "New York", Osoba.Spol.M, loremIpsum, 9, 7));
        glumci.add(new Glumac(R.drawable.julie_delpy, "Julie", "Delpy", 1969, -1,
                "Paris", Osoba.Spol.Z, loremIpsum, 6, 365));
        glumci.add(new Glumac(R.drawable.ethan_hawke, "Ethan", "Hawke", 1970, -1,
                "Texas", Osoba.Spol.M, loremIpsum, 9, 160));
        glumci.add(new Glumac(R.drawable.katharine_ross, "Katharine", "Ross", 1940, -1,
                "Hollywood", Osoba.Spol.Z, loremIpsum, 8, 1684));
        glumci.add(new Glumac(R.drawable.dustin_hoffman, "Dustin", "Hoffman", 1937, -1,
                "Los Angeles", Osoba.Spol.M, loremIpsum, 7, 163));
        glumci.add(new Glumac(R.drawable.mia_farrow, "Mia", "Farrow", 1945, -1,
                "Los Angeles", Osoba.Spol.Z, loremIpsum, 8, 1201));
        glumci.add(new Glumac(R.drawable.john_cassavetes, "John", "Cassavetes", 1929, 1989,
                "New York", Osoba.Spol.M, loremIpsum, 9, 1023));

        glumci.get(0).setBiografija("Audrey Hepburn was born Audrey Kathleen Hepburn-Ruston on May 4, 1929 in Brussels, Belgium. She was a blue-blood and a cosmopolitan from birth. Her mother, Ella van Heemstra, was a Dutch baroness; Audrey's father, Joseph Victor Anthony Hepburn-Ruston, was born in Úzice, Bohemia, of English and Austrian descent, and worked in business.\n" +
                "\n" +
                "After her parents divorced, Audrey went to London with her mother where she went to a private girls school. Later, when her mother moved back to the Netherlands, she attended private schools as well. While she vacationed with her mother in Arnhem, Netherlands, Hitler's army took over the town. It was here that she fell on hard times during the Nazi occupation. Audrey suffered from depression and malnutrition.\n" +
                "\n" +
                "After the liberation, she went to a ballet school in London on a scholarship and later began a modeling career. As a model, she was graceful and, it seemed, she had found her niche in life--until the film producers came calling. In 1948, after being spotted modeling by a producer, she was signed to a bit part in the European film Dutch in Seven Lessons (1948).\n" +
                "\n" +
                "Later, she had a speaking role in the 1951 film, Young Wives' Tale (1951) as Eve Lester. The part still wasn't much, so she headed to America to try her luck there. Audrey gained immediate prominence in the US with her role in Roman Holiday (1953) in 1953. This film turned out to be a smashing success, and she won an Oscar as Best Actress. This gained her enormous popularity and more plum roles.\n" +
                "\n" +
                "In contrast to the \"sex goddesses\" of the silver screen, Audrey Hepburn had a more wholesome beauty and an aura of innocence and class about her which gained her many devoted fans.\n" +
                "\n" +
                "Roman Holiday (1953) was followed by another similarly wonderful performance in the 1957 classic Funny Face (1957). Sabrina (1954), in 1954, for which she received another Academy nomination, and Love in the Afternoon (1957), in 1957, also garnered rave reviews. In 1959, she received yet another nomination for her role in The Nun's Story (1959).\n" +
                "\n" +
                "Audrey reached the pinnacle of her career when she played Holly Golightly in the delightful film Breakfast at Tiffany's (1961)in 1961. For this she received another Oscar nomination. She scored commercial success again in the espionage caper Charade (1963). One of Audrey's most radiant roles was in the fine production of My Fair Lady (1964) in 1964. Her co-star, Rex Harrison, once was asked to identify his favorite leading lady. Without hesitation, he replied, \"Audrey Hepburn in 'My Fair Lady.'\" After a couple of other movies, most notably Two for the Road (1967), she hit pay dirt and another nomination in 1967's Wait Until Dark (1967).\n" +
                "\n" +
                "By the end of the sixties, after her divorce from actor Mel Ferrer, Audrey decided to retire while she was on top. Later she married Dr. Andrea Dotti. From time to time, she would appear on the silver screen. One film of note was Robin and Marian (1976), with Sean Connery in 1976.\n" +
                "\n" +
                "In 1988, Audrey became a special ambassador to the United Nations UNICEF fund helping children in Latin America and Africa, a position she retained until 1993. She was named to People's magazine as one of the 50 most beautiful people in the world. Her last film was Always (1989) in 1989.\n" +
                "\n" +
                "Audrey Hepburn died on January 20, 1993 in Tolochnaz, Switzerland, from appendicular cancer. She had made a total of 31 high quality movies. Her elegance and style will always be remembered in film history as evidenced by her being named in Empire magazine's \"The Top 100 Movie Stars of All Time.\"");

        glumci.get(1).setBiografija("Eldred Gregory Peck was born in La Jolla, California, to Bernice Mary (Ayres) and Gregory Pearl Peck, a chemist and druggist in San Diego. He had Irish (from his paternal grandmother), English, and some German, ancestry. His parents divorced when he was five years old. An only child, he was sent to live with his grandmother. He never felt he had a stable childhood. His fondest memories are of his grandmother taking him to the movies every week and of his dog, which followed him everywhere. He studied pre-med at UC-Berkeley and, while there, got bitten by the acting bug and decided to change the focus of his studies. He enrolled in the Neighborhood Playhouse in New York and debuted on Broadway after graduation. His debut was in Emlyn Williams' play \"The Morning Star\" (1942). By 1943 he was in Hollywood, where he debuted in the RKO film Days of Glory (1944).\n" +
                "\n" +
                "Stardom came with his next film, The Keys of the Kingdom (1944), for which he was nominated for an Academy Award. Peck's screen presence displayed the qualities for which he became well known. He was tall, rugged and heroic, with a basic decency that transcended his roles. He appeared in Alfred Hitchcock's Spellbound (1945) as an amnesia victim accused of murder. In The Yearling (1946), he was again nominated for an Academy Award and won the Golden Globe. He was especially effective in westerns and appeared in such varied fare as David O. Selznick's critically blasted Duel in the Sun (1946), the somewhat better received Yellow Sky (1948) and the acclaimed The Gunfighter (1950). He was nominated again for the Academy Award for his roles in Gentleman's Agreement (1947), which dealt with anti-Semitism, and Twelve O'Clock High (1949), a story of high-level stress in an Air Force bomber unit in World War II.\n" +
                "\n" +
                "With a string of hits to his credit, Peck made the decision to only work in films that interested him. He continued to appear as the heroic, larger-than-life figures in such films as Captain Horatio Hornblower R.N. (1951) and Moby Dick (1956). He worked with Audrey Hepburn in her debut film, Roman Holiday (1953). Peck finally won the Oscar, after four nominations, for his performance as lawyer Atticus Finch in To Kill a Mockingbird (1962). In the early 1960s he appeared in two darker films than he usually made, Cape Fear (1962) and Captain Newman, M.D. (1963), which dealt with the way people live. He also gave a powerful performance as Capt. Keith Mallory in The Guns of Navarone (1961), one of the biggest box-office hits of that year.\n" +
                "\n" +
                "In the early 1970s he produced two films, The Trial of the Catonsville Nine (1972) and The Dove (1974), when his film career stalled. He made a comeback playing, somewhat woodenly, Robert Thorn in the horror film The Omen (1976). After that, he returned to the bigger-than-life roles he was best known for, such as MacArthur (1977) and the monstrous Nazi Dr. Josef Mengele in the huge hit The Boys from Brazil (1978). In the 1980s he moved into television with the mini-series The Blue and the Gray (1982) and The Scarlet and the Black (1983). In 1991 he appeared in the remake of his 1962 film, playing a different part, in Martin Scorsese's Cape Fear (1991). He was also cast as the progressive-thinking owner of a wire and cable business in Other People's Money (1991).\n" +
                "\n" +
                "In 1967 Peck received the Academy's Jean Hersholt Humanitarian Award. He was also been awarded the US Presidential Medal of Freedom. Always politically progressive, Peck was active in such causes as anti-war protests, workers' rights and civil rights. He died in June 2003, aged 87.");

        glumci.get(2).setBiografija("Diane Keaton was born Diane Hall in Los Angeles, California, to Dorothy Deanne (Keaton), an amateur photographer, and John Newton Ignatius \"Jack\" Hall, a civil engineer and real estate broker. Her ancestry includes Irish, English, German, and Scottish.\n" +
                "\n" +
                "Keaton studied Drama at Santa Ana College before dropping out to study at the Neighborhood Playhouse in New York. After appearing in summer stock for several months, she got her first major stage role in the Broadway rock musical \"Hair.\" As understudy to the lead, she gained attention by not removing any of her clothing. In 1970, Woody Allen cast her in his Broadway play \"Play It Again, Sam,\" which had a successful run. It was during this time that she became involved with Allen and appeared in a number of his films. The first one was Play It Again, Sam (1972), the screen adaptation of the stage play. That same year Francis Ford Coppola cast her as Kay in the Oscar-winning The Godfather (1972), and she was on her way to stardom. She reprized that role in the film's first sequel, The Godfather: Part II (1974). She then appeared with Allen again in Sleeper (1973) and Love and Death (1975).\n" +
                "\n" +
                "In 1977 she broke away from her comedy image to appear in the chilling Looking for Mr. Goodbar (1977), which won her a Golden Globe nomination. It was the same year that she appeared in what many regard as her best performance, in the title role of Annie Hall (1977), which Allen wrote specifically for her (her real last name is Hall, and her nickname is Annie), and what an impact she made. She won the Oscar and the British Award for Best Actress, and Allen won the Directors Award from the DGA. She started a fashion trend with her unisex clothes and was the poster girl for a lot of young males. Her mannerisms and awkward speech became almost a national craze. The question being asked, though, was, \"Is she just a lightweight playing herself, or is there more depth to her personality?\" For whatever reason, she appeared in but one film a year for the next two years and those films were by Allen. When they broke up she was next involved with Warren Beatty and appeared in his film Reds (1981), as the bohemian female journalist Louise Bryant. For her performance she received nominations for the Academy Award and the Golden Globe. For the rest of the 1980s she appeared infrequently in films but won nominations in three of them. Attempting to break the typecasting she had fallen into, she took on the role of a confused, somewhat naive woman who becomes the tool of Middle Eastern terrorists in The Little Drummer Girl (1984). To offset her lack of movie work, Diane began directing. She directed the documentary Heaven (1987), as well as some music videos. For television she directed an episode of the popular, but strange, Twin Peaks (1990).\n" +
                "\n" +
                "In the 1990s she began to get more mature roles, though she reprized the role of Kay Corleone in the third \"Godfather\" epic, The Godfather: Part III (1990). She appeared as the wife of Steve Martin in the hit Father of the Bride (1991) and again in Father of the Bride Part II (1995). In 1993 she once again teamed with Woody Allen in Manhattan Murder Mystery (1993), which was well received. In 1995 she received high marks for Unstrung Heroes (1995), her first major feature as a director.");

        glumci.get(3).setBiografija("Woody Allen was born Allan Stewart Konigsberg on December 1, 1935 in Brooklyn, New York, to Nettie (Cherrie), a bookkeeper, and Martin Konigsberg, a waiter and jewellery engraver. His father was of Russian Jewish descent, and his maternal grandparents were Austrian Jewish immigrants. As a young boy, he became intrigued with magic tricks and playing the clarinet, two hobbies that he continues today.\n" +
                "\n" +
                "Allen broke into show business at 15 years when he started writing jokes for a local paper, receiving $200 a week. He later moved on to write jokes for talk shows but felt that his jokes were being wasted. His agents, Charles Joffe and Jack Rollins, convinced him to start doing stand-up and telling his own jokes. Reluctantly he agreed and, although he initially performed with such fear of the audience that he would cover his ears when they applauded his jokes, he eventually became very successful at stand-up. After performing on stage for a few years, he was approached to write a script for Warren Beatty to star in: What's New Pussycat (1965) and would also have a moderate role as a character in the film. During production, Woody gave himself more and better lines and left Beatty with less compelling dialogue. Beatty inevitably quit the project and was replaced by Peter Sellers, who demanded all the best lines and more screen-time.\n" +
                "\n" +
                "It was from this experience that Woody realized that he could not work on a film without complete control over its production. Woody's theoretical directorial debut was in What's Up, Tiger Lily? (1966); a Japanese spy flick that he dubbed over with his own comedic dialogue about spies searching for the secret recipe for egg salad. His real directorial debut came the next year in the mockumentary Take the Money and Run (1969). He has written, directed and, more often than not, starred in about a film a year ever since, while simultaneously writing more than a dozen plays and several books of comedy.\n" +
                "\n" +
                "While best known for his romantic comedies Annie Hall (1977) and Manhattan (1979), Woody has made many transitions in his films throughout the years, transitioning from his \"early, funny ones\" of Bananas (1971), Love and Death (1975) and Everything You Always Wanted to Know About Sex * But Were Afraid to Ask (1972); to his more storied and romantic comedies of Annie Hall (1977), Manhattan (1979) and Hannah and Her Sisters (1986); to the Bergmanesque films of Stardust Memories (1980) and Interiors (1978); and then on to the more recent, but varied works of Crimes and Misdemeanors (1989), Husbands and Wives (1992), Mighty Aphrodite (1995), _Celebrity_ and Deconstructing Harry (1997); and finally to his films of the last decade, which vary from the light comedy of Scoop (2006), to the self-destructive darkness of Match Point (2005) and, most recently, to the cinematically beautiful tale of Vicky Cristina Barcelona (2008). Although his stories and style have changed over the years, he is regarded as one of the best filmmakers of our time because of his views on art and his mastery of filmmaking.");

        glumci.get(4).setBiografija("Ingrid Bergman was one of the greatest actresses from Hollywood's lamented Golden Era. Her natural and unpretentious beauty and her immense acting talent made her one of the most celebrated figures in the history of American cinema. Bergman is also one of the most Oscar-awarded actresses, tied with Meryl Streep, both are second only to Katharine Hepburn.\n" +
                "\n" +
                "Ingrid Bergman was born in Stockholm, Sweden, on August 29, 1915, to a German mother, Frieda Henrietta (Adler), and a Swedish father, Justus Samuel Bergman, an artist and photographer. Her mother died when she was only two and her father died when she was 12. She went to live with an elderly uncle.\n" +
                "\n" +
                "The woman who would be one of the top stars in Hollywood in the 1940s had decided to become an actress after finishing her formal schooling. She had had a taste of acting at age 17 when she played an uncredited role of a girl standing in line in the Swedish film Landskamp (1932) in 1932 - not much of a beginning for a girl who would be known as \"Sweden's illustrious gift to Hollywood.\" Her parents died when she was just a girl and the uncle she lived with didn't want to stand in the way of Ingrid's dream. The next year she enrolled at the Royal Dramatic Theatre School in Stockholm but decided that stage acting was not for her. It would be three more years before she would have another chance at a film. When she did, it was more than just a bit part. The film in question was Munkbrogreven (1935), where she had a speaking part as Elsa Edlund. After several films that year that established her as a class actress, Ingrid appeared in Intermezzo (1936) as Anita Hoffman. Luckily for her, American producer David O. Selznick saw it and sent a representative from Selznick International Pictures to gain rights to the story and have Ingrid signed to a contract. Once signed, she came to California and starred in United Artists' 1939 remake of her 1936 film, Intermezzo: A Love Story (1939), reprising her original role. The film was a hit and so was Ingrid. Her beauty was unlike anything the movie industry had seen before and her acting was superb. Hollywood was about to find out that they had the most versatile actress the industry had ever seen. Here was a woman who truly cared about the craft she represented. The public fell in love with her. Ingrid was under contract to go back to Sweden to film Only One Night (1939) in 1939 and June Night (1940) in 1940. Back in the US she appeared in three films, all well-received. She made only one film in 1942, but it was the classic Casablanca (1942) opposite the great Humphrey Bogart.\n" +
                "\n" +
                "Ingrid was choosing her roles well. In 1943 she was nominated for an Academy Award for her role in For Whom the Bell Tolls (1943), the only film she made that year. The critics and public didn't forget her when she made Gaslight (1944) the following year--her role of Paula Alquist got her the Oscar for Best Actress. In 1945 Ingrid played in Spellbound (1945), Saratoga Trunk (1945) and The Bells of St. Mary's (1945), for which she received her third Oscar nomination for her role of Sister Benedict. She made no films in 1947, but bounced back with a fourth nomination for Joan of Arc (1948). In 1949 she went to Italy to film Stromboli (1950), directed by Roberto Rossellini. She fell in love with him and left her husband, Dr. Peter Lindstrom, and daughter, Pia Lindström. America's \"moral guardians\" in the press and the pulpits were outraged. She was pregnant and decided to remain in Italy, where her son was born. In 1952 Ingrid had twins, Isotta and Isabella Rossellini, who became an outstanding actress in her own right, as did Pia. Ingrid continued to make films in Italy and finally returned to Hollywood in 1956 in the title role in Anastasia (1956), which was filmed in England. For this she won her second Academy Award. She had scarcely missed a beat. Ingrid continued to bounce between Europe and the US making movies, and fine ones at that. A film with Ingrid Bergman was sure to be a quality production. In her final big-screen performance in 1978's Autumn Sonata (1978) she had her final Academy Award nomination. Though she didn't win, many felt it was the most sterling performance of her career. Ingrid retired, but not before she gave an outstanding performance in the mini-series A Woman Called Golda (1982), a film about Israeli prime minister Golda Meir. For this she won an Emmy Award as Best Actress, but, unfortunately, she didn't live to see the fruits of her labor. Ingrid died from cancer on August 29, 1982, her 67th birthday, in London, England.");

        glumci.get(5).setBiografija("Humphrey DeForest Bogart was born in New York City, New York, to Maud Humphrey, a famed magazine illustrator and suffragette, and Belmont DeForest Bogart, a moderately wealthy surgeon (who was secretly addicted to opium). Bogart was educated at Trinity School, NYC, and was sent to Phillips Academy in Andover, Massachusetts, in preparation for medical studies at Yale. He was expelled from Phillips and joined the U.S. Naval Reserve. From 1920 to 1922, he managed a stage company owned by family friend William A. Brady (the father of actress Alice Brady), performing a variety of tasks at Brady's film studio in New York. He then began regular stage performances. Alexander Woollcott described his acting in a 1922 play as inadequate. In 1930, he gained a contract with Fox, his feature film debut in a ten-minute short, Broadway's Like That (1930), co-starring Ruth Etting and Joan Blondell. Fox released him after two years. After five years of stage and minor film roles, he had his breakthrough role in The Petrified Forest (1936) from Warner Bros. He won the part over Edward G. Robinson only after the star, Leslie Howard, threatened Warner Bros. that he would quit unless Bogart was given the key role of Duke Mantee, which he had played in the Broadway production with Howard. The film was a major success and led to a long-term contract with Warner Bros. From 1936 to 1940, Bogart appeared in 28 films, usually as a gangster, twice in Westerns and even a horror film. His landmark year was 1941 (often capitalizing on parts George Raft had stupidly rejected) with roles in classics such as High Sierra (1941) and as Sam Spade in one of his most fondly remembered films, The Maltese Falcon (1941). These were followed by Casablanca (1942), The Big Sleep (1946), and Key Largo (1948). Bogart, despite his erratic education, was incredibly well-read and he favored writers and intellectuals within his small circle of friends. In 1947, he joined wife Lauren Bacall and other actors protesting the House Un-American Activities Committee witch hunts. He also formed his own production company, and the next year made The Treasure of the Sierra Madre (1948). Bogie won the best actor Academy Award for The African Queen (1951) and was nominated for Casablanca (1942) and as Captain Queeg in The Caine Mutiny (1954), a film made when he was already seriously ill. He died in his sleep at his Hollywood home following surgeries and a battle with throat cancer.");

        glumci.get(6).setBiografija("Julie Delpy was born in Paris, France, in 1969 to Albert Delpy and Marie Pillet, both actors.\n" +
                "\n" +
                "She was first featured in Jean-Luc Godard's Détective (1985) at the age of fourteen. She has starred in many American and European productions since then, including Disney's The Three Musketeers (1993), Killing Zoe (1993), Three Colors: White (1994), and the \"Before\" series, alongside Ethan Hawke: Before Sunrise (1995), Before Sunset (2004), and Before Midnight (2013).\n" +
                "\n" +
                "She graduated from NYU's film school, and wrote and directed the short film Blah Blah Blah (1995), which screened at the Sundance Film Festival. She is a resident of Los Angeles.");
        glumci.get(7).setBiografija("Ethan Green Hawke was born on November 6, 1970 in Austin, Texas, to Leslie Carole (Green), a charity worker, and James Steven Hawke, an insurance actuary. His parents were students at the University of Texas at the time but divorced when Ethan was 5 years old. His mother raised him alone for the next five years, moving around the country, until she remarried in 1981 and the family settled in Princeton Junction, New Jersey.\n" +
                "\n" +
                "He attended West Windsor-Plainsboro High School and then transferred to the Hun School of Princeton and it was while he was there that he began taking acting classes at the McCarter Theatre on the Princeton campus. His early ambition had been to be a writer, but as a result of the acting lessons and appearances in student productions he persuaded his mother to allow him to attend an audition for a role in a sci-fi adolescent adventure, Explorers (1985). He got the part (along with River Phoenix) but although the movie was favourably reviewed, it met with little commercial success which discouraged Hawke from pursuing further movie roles for a few years.\n" +
                "\n" +
                "He was admitted to the prestigious Carnegie-Mellon University to study theatre but his studies were interrupted when he won his break-through role opposite Robin Williams in Dead Poets Society (1989) and he didn't complete his degree.\n" +
                "\n" +
                "His subsequent acting career was a mix of theatre work (earning a number of awards and nominations, including a Tony nomination for his role in The Coast of Utopia at the Lincoln Center in New York), and a mix of \"serious\" and more commercial movies, notably Gattaca (1997) (where he met his first wife, Uma Thurman) and Training Day (2001).\n" +
                "\n" +
                "Meanwhile, he also pursued his childhood ambition and has written two novels and several screenplays.");

        glumci.get(8).setBiografija("Katharine Juliet Ross was born on January 29, 1940 in Hollywood, California, to Katharine W. (Hall) and Dudley T. Ross. Her father, who also worked for the Associated Press, was away in the US Navy when she was born. His navy career shuttled the family around to Virginia, then Palo Alto, and finally to Walnut Creek, outside of San Francisco, where Ross grew up. Katharine's ancestry includes Scottish, German, Channel Islander (Guernsey), and English.\n" +
                "\n" +
                "Ross graduated from Las Lomas High School in Walnut Creek in 1957 and attended Diablo Valley College in the Bay Area, where she took part in her first onscreen work in a student film. Moving to San Francisco, into an apartment on Stockton Street above a grocery store, she began her acting career as an understudy in Actor's Workshop productions, and was soon auditioning for roles.\n" +
                "\n" +
                "Work came quickly for Ross, at first mainly in television westerns, and indeed Westerns would make up the majority of her best-known work, her natural beauty being a strong asset in that genre. Her first film role was in the Civil War era Shenandoah (1965) starring James Stewart. Ross's career as a leading actress began in earnest in 1967, with her strong turn co-starring with James Caan and Simone Signoret in Games (1967), and with The Graduate (1967). Ross's performance as Elaine earned her a Supporting Actress Oscar nomination.\n" +
                "\n" +
                "A disappointing, formulaic John Wayne vehicle, Hellfighters (1968), followed but she soon returned to form with two films with Robert Redford. As Etta Place in Butch Cassidy and the Sundance Kid (1969), Ross was part of the most memorable scene from that hit film, precariously perched barefoot on the bumper of that newfangled contraption, the bicycle, as Paul Newman's Butch Cassidy takes her for a ride. The compelling Tell Them Willie Boy Is Here (1969) was less of a box office success but more highly regarded by the critics, and Ross won a BAFTA Award for her work as Lola, a Paiute Indian who flees with her boyfriend, played by Robert Blake, after he kills her father in self-defense.\n" +
                "\n" +
                "Swept up into a whirlwind of fame, widely idealized as the symbol of beauty for the Woodstock generation, Ross had accomplished so much so quickly that it seemed her entire career had happened almost all at once, in that frenzy of activity between 1967 and 1969. Sure enough, there followed a long dry spell in which she was mostly cast in forgettable roles; her next strong film wasn't for another six years. In The Stepford Wives (1975), an intriguing black comedy-cum-horror film, Ross plays a independent, free-spirited wife newly relocated to a suburb where the other wives all seem to be just a little too perfect, too submissive; it was arguably her strongest performance to date, but Stepford Wives would prove to be but a temporary resurgence for Ross, and her work in the decade and a half to follow would include such star-studded duds as The Betsy (1978), and a return to TV, including a part in primetime soap opera The Colbys (1985). Along the way, however, Ross found love. After four failed marriages, she met her present husband Sam Elliott, while working on The Legacy (1978). The two actors married in 1984, and in the same year had a daughter, Cleo.\n" +
                "\n" +
                "In 1991, Ross and Elliott adapted the Louis L'Amour novel, Conagher (1991), for television in a remarkably affecting Western tale which showcases both actors' remarkable talents. Ross continues to take roles on occasion and, as usual, her work is strong -- something that was sometimes overlooked in her youth due to her famous beauty. For instance, Ross turned up in Donnie Darko (2001), in a solid performance as Donnie's psychiatrist.\n" +
                "\n" +
                "Ross and Elliott live on their ranchito in Malibu.");

        glumci.get(9).setBiografija("Dustin Lee Hoffman was born in Los Angeles, California, to Lillian (Gold) and Harry Hoffman, who was a furniture salesman and prop supervisor for Columbia Pictures. He was raised in a Jewish family (from Ukraine, Russia-Poland, and Romania). Hoffman graduated from Los Angeles High School in 1955, and went to Santa Monica City College, where he dropped out after a year due to bad grades. But before he did, he took an acting course because he was told that \"nobody flunks acting.\" Also received some training at Los Angeles Conservatory of Music. Decided to go into acting because he did not want to work or go into the service. Trained at The Pasadena Playhouse for two years.");

        glumci.get(10).setBiografija("Mia Farrow was born in Los Angeles, California, to director John Farrow and actress and Tarzan-girl Maureen O'Sullivan. Her father was Australian-born (of English descent) and her mother was Irish-born (of Irish, Scottish, and English ancestry).\n" +
                "\n" +
                "Farrow debuted at the movies in 1959 in very small roles. She was noticed for the first time in the film Rosemary's Baby (1968) by Roman Polanski. She showed her talent also on TV and at the theatre, but her final breakthrough was when she met Woody Allen and became his Muse after the film A Midsummer Night's Sex Comedy (1982). After that, Woody Allen wrote many other roles for her.");

        glumci.get(11).setBiografija("John Cassavetes was born on December 9, 1929 in New " + "\n" +
                "York City, New York, USA as John Nicholas Cassavetes. He was an actor and director, " + "\n" +
                "known for Rosemary's Baby (1968), The Dirty Dozen (1967) and Opening Night (1977). " + "\n" +
                "He was married to Gena Rowlands. He died on February 3, 1989 in Los Angeles, California, USA.");

        reziseri.add(new Reziser("Ingmar", "Bergman"));
        reziseri.add(new Reziser("Quentin", "Tarantino"));
        reziseri.add(new Reziser("Stanley", "Kubrick"));
        reziseri.add(new Reziser("Krzysztof", "Kieslowski"));
        reziseri.add(new Reziser("John", "Ford"));
        reziseri.add(new Reziser("Roman", "Polanski"));
        reziseri.add(new Reziser("Andrei", "Tarkovsky"));
        reziseri.add(new Reziser("Alejandro", "Jodorowsky"));
        reziseri.add(new Reziser("Orson", "Welles"));
        reziseri.add(new Reziser("David", "Lynch"));

        zanrovi.add(new Zanr("Akcija", R.drawable.akcija));
        zanrovi.add(new Zanr("Animirani", R.drawable.animirani));
        zanrovi.add(new Zanr("Avantura", R.drawable.avantura));
        zanrovi.add(new Zanr("Dokumentarac", R.drawable.dokumentarac));
        zanrovi.add(new Zanr("Historijski", R.drawable.historijski));
        zanrovi.add(new Zanr("Horor", R.drawable.horor));
        zanrovi.add(new Zanr("Komedija", R.drawable.komedija));
        zanrovi.add(new Zanr("Naučna fantastika", R.drawable.naucna_fantastika));
        zanrovi.add(new Zanr("Porodični", R.drawable.porodicni));
        zanrovi.add(new Zanr("Romantični", R.drawable.romanticni));
        zanrovi.add(new Zanr("Triler", R.drawable.triler));
        zanrovi.add(new Zanr("Vestern", R.drawable.vestern));

    }
}
