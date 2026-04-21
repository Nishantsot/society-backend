package portal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import portal.Entity.Society;
import portal.Entity.User;
import portal.Repository.SocietyRepository;
import portal.Repository.UserRepository;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final SocietyRepository societyRepo;
    private final UserRepository userRepo;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {

            User user = userRepo.findByEmail("test@gmail.com")
                    .orElseGet(() -> {
                        User newUser = new User();
                        newUser.setName("Admin");
                        newUser.setEmail("test@gmail.com");
                        newUser.setPassword("1234");
                        return userRepo.save(newUser);
                    });

            societyRepo.deleteAll();

            if (societyRepo.count() == 0) {

                

                List<Society> societies = List.of(

                        // 🔥 ROBOGYAN
                        createSociety(
                                "ROBOGYAN",
                                "Robogyan - the official robotics society of ADGIPS and the oldest tech society of the college, established in 2011 - embodies a rich legacy of innovation, technical excellence, and competitive achievement. Over the years, the society has played a pivotal role in fostering a strong culture of hands-on learning, problem-solving, and technological leadership. Robogyan has earned national recognition by winning the Smart India Hackathon multiple times and securing top positions in national-level robotics competitions hosted at premier IITs across India. These accomplishments highlight the society’s ability to deliver impactful, real-world solutions through collaboration, technical depth, and sustained effort.\n" +
                                        "Beyond competitions, Robogyan actively drives experiential learning through hackathons, robotics challenges, technical workshops and expert-led sessions. The society also takes pride in its strong alumni network, with former members contributing to leading multinational companies and founding successful startups, reflecting the long-term impact and mentorship culture nurtured within the society.\n" +
                                        "At its core, Robogyan strives to develop technically skilled, innovative, and socially responsible individuals who are motivated by curiosity, teamwork, and a commitment to building solutions that matter.",
                                "To bridge the gap between theoretical knowledge and real-world application, creating a community of engineers who lead through creation, discovery, and the sheer joy of learning.",
                                "Mission of the Society:\n" +
                                        "At Robogyan, we live by the motto \"Experience Engineering.\" Our mission is to provide more than just workshops; we provide a sandbox for innovation. We focus on:\n" +
                                        "• Active Learning: Prioritizing \"doing\" over \"watching.\"\n" +
                                        "• Experimental Growth: Encouraging members to push their technical boundaries.\n" +
                                        "• Joyful Discovery: Restoring the excitement and wonder inherent in the engineering process.",
                                "In one of the largest on-campus technical events of the year, Robogyan hosted the Internal Hackathon for SIH 2025. Over 1,100 students pushed their limits across two days of intense problem-solving and prototyping. The event was highly commended by our respected Director for its seamless execution and high-caliber output",
                                "The Result: 5 teams from our college advanced to the SIH National Finals - a success rate that surpassed several major IITs and solidified Robogyan's reputation as a powerhouse for practical engineering.",
List.of(
    "https://society-backend-r6pe.onrender.com/images/robogyan1.png",
    "https://society-backend-r6pe.onrender.com/images/robogyan2.png",
    "https://society-backend-r6pe.onrender.com/images/robogyan3.png",
    "https://society-backend-r6pe.onrender.com/images/robogyan4.png"
),
                                List.of(  "Amogh Saxena – President",
                        "Aditya Goel – Vice President",
                        "Abhishek Singh Chauhan – IoT Lead",
                        "Dev Chandra – Robotics Lead",
                        "Ayush Kumar Jha – Firmware Lead",
                        "Pranav Bisht – Embedded Lead",
                        "Aditya Aggarwal – 3D Design Lead",
                        "Sneha Mukherjee – Control Systems Lead"),
                                "robogyan",
                                "https://robogyan.tech/",
                                "robogyan_official",
                                "https://www.linkedin.com/company/robogyan",
                                "https://society-backend-r6pe.onrender.com/Uploads/robogyan.png",
                            
                                user
                        ),

                        // 🔥 AVANT GARDE
                        createSociety(
                                "AVANT GARDE",
                                "Society Description:\n" +
                                        "Avant Garde- the official art society of ADGIPS, established in 2018, stands as a dynamic collective of creative individuals committed to visual expression, artistic exploration, and cultural engagement. Over the years, the society has cultivated a vibrant space where ideas take form through art, fostering a culture of creativity, collaboration, and experimentation.\n" +
                                        "Avant Garde has consistently contributed to the college’s creative landscape through exhibitions, murals, artwalks, competitions, and collaborative projects, bringing art out of confined spaces and into shared experiences. One of its key highlights is Candescent, the society’s themed annual art fest hosted during the college fest, where artists come together to showcase their work and engage audiences through visual storytelling.\n" +
                                        "The society plays an active role in shaping the aesthetic identity of major college events, including large-scale contributions to fest setups and thematic installations such as Utkarsh, where art becomes a medium to translate ideas into immersive environments.\n" +
                                        "Beyond events, Avant Garde emphasizes hands-on learning, peer collaboration, and creative dialogue, encouraging members to experiment across mediums and develop their unique artistic voice. The society also takes pride in building a supportive and evolving community, where both experienced artists and beginners grow together.\n" +
                                        "At its core, Avant Garde aims to nurture individuals who are not only skilled in their craft but also thoughtful, expressive, and capable of using art as a means to observe, interpret, and influence the world around them.",
                                "To create a space where creativity thrives beyond boundaries, empowering individuals to explore, express, and evolve through art while building a culture that values originality, collaboration, and meaningful visual expression.",
                                "At Avant Garde, we stand by the motto “If nothing else, believe in art.”. Our mission is to build an environment where art is experienced, not just observed. We focus on:\n" +
                                        "• Active Creation: Encouraging members to practice, experiment, and produce consistently.\n" +
                                        "• Creative Exploration: Pushing boundaries across styles, mediums, and ideas.\n" +
                                        "• Collaborative Growth: Building a community where artists learn from and inspire each other.\n" +
                                        "• Meaningful Expression: Using art as a tool to communicate, question, and connect.",
                                "In one of the most visually immersive and large-scale creative contributions to the college’s annual fest, Utkarsh 2026, Avant Garde played a central role in bringing the fest theme “Virasat se Vikas Tak – Evolution Through Heritage” to life...",
                                "Avant Garde successfully delivered a cohesive visual identity for Utkarsh...",
                               List.of(
    "https://society-backend-r6pe.onrender.com/images/avant1.png",
    "https://society-backend-r6pe.onrender.com/images/avant2.png"
),

List.of(
    "Yug Bhagat – President",
    "Anoop Arpan – Vice President",
    "Pallavi Verma – General Secretary",
    "Gautam Saini – Graphics Head",
    "Vivek – Social Media Head",
    "Riya Kumar – Creative Head",
    "Parth Verma – Marketing Head",
    "Devansh – Content Head"
),
                                "avantgarde.adgips",
                                 "",                    // website (add later if needed)
    "@avantgarde5535",     // youtube
    "",   
     "https://society-backend-r6pe.onrender.com/Uploads/avant.png",
                                user
                        ),

                        // 🔥 CONFLUENZ
createSociety(
    "CONFLUENZ",

    "Confluenz — the official photography society of ADGIPS, founded in 2015 — is one of the most recognized and respected creative communities within the college, with photography at its core. While the society also thrives in cinematography and graphic design, its primary strength lies in capturing compelling visual narratives, making it the leading photography and media society on campus.\n" +
    "Over the years, Confluenz has built a strong presence across all major college events, playing a crucial role in documenting and elevating moments from cultural festivals, technical fests, sports meets, and flagship institutional programs. The society is deeply integrated into the college ecosystem, ensuring high-quality coverage and creative excellence at every level.\n" +
    "Structured across photography, cinematography, and graphics departments, Confluenz fosters a collaborative and hands-on environment through workshops, photowalks, and real-time event exposure.\n" +
    "At its core, Confluenz represents passion, precision, and storytelling driven by individuals who aim to create meaningful visual experiences.",

    "To cultivate a dynamic community of creators who transform vision into reality through photography, filmmaking, and design — driven by curiosity, collaboration, and powerful storytelling.",

    "• Expressive Storytelling through photography and cinematography\n" +
    "• Creative Design Excellence in graphics and branding\n" +
    "• Hands-on Learning through real-time projects\n" +
    "• Technical Mastery of tools like Photoshop, Lightroom, Premiere Pro, After Effects, DaVinci Resolve, Canva\n" +
    "• Building confidence, teamwork, and creative thinking",

    "Major Activities:\n" +
    "• Complete visual coverage of UTKARSH fest\n" +
    "• Chitraka – Flagship photography exhibition\n" +
    "• Filmmaking competition with Yakshagan\n" +
    "• Media partner for CodeVeda Hackathon (Gurugram)\n" +
    "• Participation in Miranda House, JIMS, Kirori Mal, SGGSCC, DDU College events",

    "• Top positions in inter-college competitions\n" +
    "• Strong reputation as official media society\n" +
    "• Skilled members in industry-standard tools\n" +
    "• Regular workshops and hands-on training",

    List.of(
    "https://society-backend-r6pe.onrender.com/confluez1.png"
    
),

    List.of(
        "Nikhil Sood – President",
        "Vansh Madan – Vice President",
        "Lakshit Bharadwaj – General Secretary",
        "Akshat – Graphics Head",
        "Ali Imam – Cinematography Head",
        "Vivek – Media Head",
        "Pranay – Advisory Head",
        "Maneesh – Advisory Head"
    ),

    // 🔥 SOCIAL LINKS
    "confluenz",   // instagram username
    "",            // website
    "",            // youtube
    "https://www.linkedin.com/company/confluenz-adgips/",

        "https://society-backend-r6pe.onrender.com/confluez.png"
,

    user
),

                        // 🔥 SPORTS COMMITTEE (FULL TEXT)
                        createSociety(
                                "SPORTS COMMITTEE",
                                "The ADGIPS Sports Committee is the official sports society of the college, responsible for managing and organizing all sports-related activities. It works towards promoting sportsmanship, teamwork, discipline, and active participation among students, while ensuring smooth execution of events at both intra and inter-college levels.",
                                "To create a strong and inclusive sports culture that encourages excellence, teamwork, and overall student development.",
                                "• To provide a platform for students to showcase their athletic talent\n" +
                                        "• To promote fitness, discipline, and mental well-being\n" +
                                        "• To organize well-structured and large-scale sporting events\n" +
                                        "• To represent the college at university and inter-college competitions\n" +
                                        "• To build leadership and team spirit among students",
                                "Major Events & Activities:\n" +
                                        "1. ASTITVA – Annual Sports Fest (100+ colleges participation)\n" +
                                        "2. Inter-college sports tournaments\n" +
                                        "3. Intra-college competitions\n" +
                                        "4. Participation in IPU Sports Meet\n" +
                                        "5. Management and execution of all sports activities",
                                "• Successfully organized ASTITVA with participation from 100+ colleges\n" +
                                        "• Conducted multiple inter and intra-college sports events\n" +
                                        "• Strong performance and medal wins in IPU Sports Meet\n" +
                                        "• Built an active and competitive sports environment in the college",
                                List.of("/Uploads/sports1.png", "/Uploads/sports2.png"),
                                List.of(
                                        "Ashish Sharma (AIML, 4th Year) – President",
                                        "Nidhi Sinha (IT, 4th Year) – President",
                                        "Parul Sinha (AIDS, 3rd Year) – Vice President",
                                        "Lavanya Khanna (CSE, 2nd Year) – Creative Head",
                                        "Piyush Bhardwaj (IT, 3rd Year) – General Secretary",
                                        "Garv Mehta (BBA, 3rd Year) – PR Head",
                                        "Aaryan Singh (CSE, 3rd Year) – Ground Work Head",
                                        "Samman (BBA, 2nd Year) – Member"
                                ),
                                    "adgips_sports",   // instagram
    "",                // website
    "",                // youtube
    "",                // linkedin
                                "https://society-backend-r6pe.onrender.com/Uploads/sport.png",
                                user
                        ),
                                     createSociety(
    "GDGC ADGIPS",

    "We are the Google Developer Group On Campus (GDGC) at ADGIPS, a community of builders, innovators, and problem-solvers shaping the future of tech. With 3,000+ active members and 250+ impactful events, we’ve created a space where ideas turn into projects, skills turn into careers, and students turn into leaders.",

    "Building a strong developer community and helping students gain practical skills and industry exposure.",

    "• Build a strong developer community\n" +
    "• Provide practical learning opportunities\n" +
    "• Promote innovation and problem-solving\n" +
    "• Help students gain industry exposure",

    "Major Events:\n" +
    "• Hack & Chill – 36-hour flagship hackathon\n" +
    "• Smart India Hackathon (SIH) campus editions\n" +
    "• Web3 Roadshows\n" +
    "• Cybersecurity Month",

    "• 3,000+ active members\n" +
    "• 250+ impactful events\n" +
    "• Successfully hosted large-scale Hack & Chill series with 3,000+ registrations\n" +
    "• Built one of the most active tech communities in the college",

    List.of(
        "https://via.placeholder.com/310",
        "https://via.placeholder.com/311"
    ),

    List.of(
        "Mehak Agarwal – President",
        "Rohit Chaudhary – Vice President",
        "Aman Sharma – General Secretary",
        "Arnav Singla – Management",
        "Somil Chaudhary – Technical",
        "Mridul Chaudhary – AI-ML",
        "Gautam Sharma – Cyber Security",
        "Abhitha Nandy – Content"
    ),

    // 🔥 SOCIAL LINKS
    "gdgc_adgips",   // instagram username
    "",              // website (add later if needed)
    "",              // youtube
    "",              // linkedin

"https://society-backend-r6pe.onrender.com/Uploads/gdc.png",
    user
),
createSociety(
    "ENACTUS ADGIPS",

    "Enactus ADGIPS is a student-driven community of entrepreneurial leaders who see opportunities where others see challenges. Guided by academic advisors and business experts, we use innovation and business principles to create impactful, sustainable projects that improve livelihoods and empower communities. We are committed to shaping a better, more sustainable world while developing the next generation of socially responsible leaders.",

    "To create a better, more sustainable world.",

    "• To engage the next generation of entrepreneurial leaders\n" +
    "• Use innovation and business principles to improve the world\n" +
    "• Build impactful and sustainable projects\n" +
    "• Empower communities and improve livelihoods",

    "Major Events:\n" +
    "• Gnosis – Flagship business and innovation event with competitions\n" +
    "• Gutargu Magazine Launch – Annual publication on social issues\n" +
    "• Akhiljyot – Large-scale blood donation camp in collaboration with ADGIPS",

    "• Secured 8+ trophies in national and inter-college competitions\n" +
    "• 1st Prize at IIT Roorkee ‘Envision’\n" +
    "• Winner at Bennett University competition\n" +
    "• Massive outreach through blogs, magazine, and community projects",

    List.of(
        "https://via.placeholder.com/320",
        "https://via.placeholder.com/321"
    ),

    List.of(
        "Shruti – President",
        "Shivam – Vice President",
        "Kushal – General Secretary",
        "Sujal – PR Head",
        "Aniket – Social Media Head",
        "Ankit – Graphics Head",
        "Granth – Photography Head",
        "Radhika – Marketing & Campaigns Head",
        "Yug – Sponsorship Head",
        "Tushar – Technical Head",
        "Aman – Research & Content Head",
        "Priyanshu – Project Vriksh Head",
        "Swastika – Project Vriksh Head",
        "Vishv – Project Navodaya Head",
        "Ruby – Project Navodaya Head",
        "Mounika – Project Astitva Head",
        "Lakshay – Project Astitva Head"
    ),

    // 🔥 SOCIAL LINKS
    "enactus.adgips",   // instagram username
    "",                 // website (none given)
    "",                 // youtube
    "https://www.linkedin.com/company/enactus-adgips/",

"https://society-backend-r6pe.onrender.com/Uploads/enactus.png",

    user
),
createSociety(
    "INSYNC",

    "Insync, the western dance society of ADGIPS, provides a dynamic platform for students to express themselves through dance, regardless of their skill level. The society is known for its versatility across multiple dance styles, including Afro, Hip-Hop, Waacking, and House. With powerful performances and consistent dedication, Insync has secured victories on prestigious stages, notably at Anugoonj, the largest cultural fest of IPU. The passion and energy of the team make it an integral part of the college’s cultural identity, continuously inspiring creativity and rhythm within the student community.",

    "To create an inclusive space where every student can discover their rhythm and grow as a performer.",

    "• Encourage learning and exploration of diverse dance forms\n" +
    "• Foster creativity, choreography, and innovation\n" +
    "• Build a strong, supportive, and united community\n" +
    "• Help members evolve both individually and as a team\n" +
    "• Create impactful performances that resonate with audiences",

    "Major Events:\n" +
    "• Inferno – Western solo dance competition (21 Feb 2026)\n" +
    "• Nach Baliye – Western duet competition (21 Feb 2026)\n" +
    "• Hoof'it – Western group competition (19 Feb 2026)",

    "• 7-time Anugoonj Winners\n" +
    "• 1st Positions at MIET, Deshbandhu College, IIMT Greater Noida\n" +
    "• 2nd Positions at KCC and IPEC\n" +
    "• 3rd Position at Deshbandhu College\n" +
    "• Consistent growth and high-energy performances",

   List.of(
    "https://society-backend-r6pe.onrender.com/images/insyc1.png",
    "https://society-backend-r6pe.onrender.com/images/insyc2.png",
    "https://society-backend-r6pe.onrender.com/images/insyc3.png"
),

    List.of(
        "Anjali Sharma – President",
        "Aaren Mittal – Vice President",
        "Divya Yadav – PR Head",
        "Priyanshiye Jain – Core Member",
        "Satyam Anand – Core Member",
        "Aditya Sinha – Core Member",
        "Yukti Sharma – Core Member",
        "Anant Jain – Core Member",
        "Priyanshi Suneja – Core Member"
    ),

    // 🔥 SOCIAL LINKS
    "dazzlersthewesterndancesoc",  // instagram username
    "",                            // website
    "",                            // youtube
    "",                            // linkedin

"https://society-backend-r6pe.onrender.com/Uploads/insyc.png",

    user
),
createSociety(
    "WORD WIZARDS",

    "Word Wizards is the official student development society of first-year B.Tech students at ADGIPS. The society is dedicated to nurturing students into confident communicators, critical thinkers, and future leaders. We focus on practical skill development, especially in communication, public speaking, personality development, and leadership. Unlike traditional societies, Word Wizards emphasizes learning by doing through interactive events, real-life simulations, competitions, and collaborative activities that help students grow beyond academics.",

    "To create a generation of confident, expressive, and capable individuals who can lead, communicate, and make an impact in any field they choose.",

    "• Enhance communication and public speaking skills\n" +
    "• Build confidence and personality development among freshers\n" +
    "• Provide real-world exposure and practical learning\n" +
    "• Develop leadership, teamwork, and problem-solving skills\n" +
    "• Help students discover and unlock their true potential",

    "Major Events:\n" +
    "• Induction Program – Large-scale orientation event for first-year students with activities, sessions, and speaker interaction (Tushika Rawat, 2026)\n" +
    "• Escape Room – High-engagement Utkarsh event focused on problem-solving, teamwork, and critical thinking",

    "• Created a supportive environment reducing gap between juniors and seniors\n" +
    "• Helped students overcome stage fear and gain confidence\n" +
    "• Encouraged introverted students to become expressive\n" +
    "• Promoted peer learning, collaboration, and leadership growth\n" +
    "• Guided students in early college journey and personality development",

    List.of(
        "https://via.placeholder.com/340",
        "https://via.placeholder.com/341"
    ),

    List.of(
        "Vishv Dhama – President",
        "Nikunj Sharma – Vice President",
        "Srishti Aggarwal – General Secretary",
        "Dr. Suryya Farhat – Society Coordinator"
    ),

    // 🔥 SOCIAL LINKS
    "word.wizards.adgips",   // instagram username
    "",                      // website
    "",                      // youtube
    "https://www.linkedin.com/company/word-wizards-adgips/",

"https://society-backend-r6pe.onrender.com/Uploads/wizard.png",

    user
),
createSociety(
    "YAKSHAGAN",

    "Yakshagan, the official dramatics and filmmaking society of ADGIPS, established in 2011, stands as a bastion of art, storytelling, and competitive excellence. For over a decade, the society has served as a cradle for artistic growth, nurturing a culture where raw talent is refined through disciplined dramaturgy and the visceral energy of live performances. Yakshagan has solidified its presence in the Delhi Collegiate Circuit, consistently clinching top honors at prestigious theatre festivals, Nukkad Natak competitions, and filmmaking competitions. These accolades reflect the ensemble’s ability to command the stage through collective synergy, thematic depth, and a relentless pursuit of thespian excellence.\n" +
    "Beyond the stage, Yakshagan is a hub of experiential learning, driving creative exploration through theatre workshops, script-writing sessions, and performance-based activities. The society takes pride in its strong alumni network, with members progressing into cinema, professional theatre, and creative media.",

    "To develop individuals who view the stage as both a mirror to society and a platform for change, guided by the philosophy 'Respect the stage and the stage will respect you'.",

    "• Create an environment for artistic expression and storytelling\n" +
    "• Maintain high technical and creative standards\n" +
    "• Conduct regular workshops for skill development\n" +
    "• Encourage intra-society competitions\n" +
    "• Provide theatre exposure across competitions and networks",

    "Major Events:\n" +
    "• Jagran – Street Play Competition (200+ participants, social awareness themes)\n" +
    "• Yugantar – Mono Act Competition (individual performance showcase)\n" +
    "• Stage Play Competition (100+ participants, full production plays)\n" +
    "• Annual Utkarsh stage production by Yakshagan",

    "• 3rd Prize in Street Play Competition (inter-college)\n" +
    "• 1st Prize and two 2nd Prizes in Stage Play Competitions\n" +
    "• Best Actor awards in Stage Play and Street Play categories\n" +
    "• Performed 20–30 productions across inter-college competitions",

    List.of(
        "https://via.placeholder.com/350",
        "https://via.placeholder.com/351"
    ),

    List.of(
        "Kavya S. Kumar – President (4th Year)",
        "Prachi Joshi – President (4th Year)",
        "Pranshu Sharma – Street Head (4th Year)",
        "Soumil Chaddha – Filmmaking Head (4th Year)",
        "Priyanshi Sharma – General Secretary (3rd Year)",
        "Aditi Arora – PR Head (3rd Year)",
        "Kanishk Tyagi – PR Head (3rd Year)",
        "Sanskriti – Production Head (3rd Year)"
    ),

    // 🔥 SOCIAL LINKS
    "yakshagan_",   // instagram username
    "",             // website
    "",             // youtube
    "",             // linkedin

"https://society-backend-r6pe.onrender.com/Uploads/yak.png",

    user
),
createSociety(
    "GEEKSFORGEEKS ADGIPS",

    "GeeksforGeeks ADGIPS is the official technical society of ADGIPS, dedicated to empowering students through coding, development, and technology-driven learning. The society actively works towards enhancing students’ technical capabilities by organizing workshops, hackathons, webinars, and hands-on sessions. With a strong focus on practical learning and industry exposure, GeeksforGeeks ADGIPS strives to build a vibrant tech community within the college, encouraging innovation, problem-solving, and collaboration.",

    "To create a dynamic and inclusive tech community that nurtures innovation, fosters continuous learning, and empowers students to excel in the ever-evolving world of technology.",

    "• Promote technical excellence through hands-on learning\n" +
    "• Encourage problem-solving and innovation\n" +
    "• Provide industry exposure through workshops and sessions\n" +
    "• Build strong coding and development foundations\n" +
    "• Support career readiness and placement success",

    "Major Events:\n" +
    "• Unlocking the Power of MERN – Session by Saurabh Bansal\n" +
    "• Data Science Unleashed – Hackathon strategies by Harshvardhan Singh\n" +
    "• MLOps with Azure – Live The Code 3.0 Hackathon session\n" +
    "• GFG Hackfest’24 – Major innovation hackathon\n" +
    "• GFG 160 Challenge – Structured DSA program\n" +
    "• Career Guidance Workshop – by ex-ISRO scientist Chandran Jha\n" +
    "• 100 Days Aptitude Series – Continuous placement preparation program",

    "• Successfully organized large-scale technical events and hackathons\n" +
    "• Strong participation and wins in inter-college competitions\n" +
    "• Built strong coding culture in college\n" +
    "• Continuous engagement through DSA and aptitude programs",

   List.of(
    "https://society-backend-r6pe.onrender.com/images/geek1.png",
    "https://society-backend-r6pe.onrender.com/images/geek2.png",
    "https://society-backend-r6pe.onrender.com/images/geek3.png",
    "https://society-backend-r6pe.onrender.com/images/geek4.png"
),
       
    List.of(
        "Aashi Maheshwari – President",
        "Pranay Kumar – Vice President",
        "Siddheshwar Pandey – Event Lead",
        "Simran Vig – Marketing Lead",
        "Amit Rastogi – Graphics & Design Lead",
        "Parth Ahuja – Tech Lead",
        "Rohit Kumar – Video Editing Lead",
        "Raj Mishra – PR & Social Media Lead"
    ),

    // 🔥 SOCIAL LINKS
    "geeksforgeeks_adgips",   // instagram username
    "",                      // website
    "geeksforgeeks_adgips",  // youtube channel
    "https://www.linkedin.com/company/geeksforgeeks-student-chapter-adgips/",

"https://society-backend-r6pe.onrender.com/Uploads/geek.png",

    user
)

                        

                );
   
                societyRepo.saveAll(societies);

                System.out.println("🔥 All societies loaded successfully");
            }
        };
    }

   private Society createSociety(
        String name,
        String description,
        String vision,
        String mission,
        String recentEvent,
        String achievements,
        List<String> images,
        List<String> coreTeam,
        String instagram,
        String website,
        String youtube,
        String linkedin,
        String logoUrl,
        User user
) {
    return Society.builder()
            .name(name)
            .description(description)
            .vision(vision)
            .mission(mission)
            .recentEvent(recentEvent)
            .achievements(achievements)
            .images(images)
            .coreTeam(coreTeam)
            .instagram(instagram)
            .website(website)
            .youtube(youtube)
            .linkedin(linkedin)
            .logoUrl(logoUrl)
            .admin(user)
            .members(List.of())
            .build();
}
}