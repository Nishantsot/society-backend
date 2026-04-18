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

            // 🔥 Get user (admin)
User user = userRepo.findByEmail("test@gmail.com")
    .orElseGet(() -> {
        User newUser = new User();
        newUser.setName("Admin");
        newUser.setEmail("test@gmail.com");
        newUser.setPassword("1234");
        return userRepo.save(newUser);
    });
           
        if (societyRepo.count() == 0) {


            Society robogyan = Society.builder()
                    .name("ROBOGYAN")
                  .description("Robogyan - the official robotics society of ADGIPS and the oldest tech society of the college, established in 2011 - embodies a rich legacy of innovation, technical excellence, and competitive achievement. Over the years, the society has played a pivotal role in fostering a strong culture of hands-on learning, problem-solving, and technological leadership. Robogyan has earned national recognition by winning the Smart India Hackathon multiple times and securing top positions in national-level robotics competitions hosted at premier IITs across India. These accomplishments highlight the society’s ability to deliver impactful, real-world solutions through collaboration, technical depth, and sustained effort.\r\n" + //
                                            "Beyond competitions, Robogyan actively drives experiential learning through hackathons, robotics challenges, technical workshops and expert-led sessions. The society also takes pride in its strong alumni network, with former members contributing to leading multinational companies and founding successful startups, reflecting the long-term impact and mentorship culture nurtured within the society.\r\n" + //
                                            "At its core, Robogyan strives to develop technically skilled, innovative, and socially responsible individuals who are motivated by curiosity, teamwork, and a commitment to building solutions that matter.\r\n" + //
                                            "")
                    .vision("To bridge the gap between theoretical knowledge and real-world application, creating a community of engineers who lead through creation, discovery, and the sheer joy of learning.")
 .mission("Mission of the Society:\r\n" + //
                                                "At Robogyan, we live by the motto \"Experience Engineering.\" Our mission is to provide more than just workshops; we provide a sandbox for innovation. We focus on:\r\n" + //
                                                "•\tActive Learning: Prioritizing \"doing\" over \"watching.\"\r\n" + //
                                                "•\tExperimental Growth: Encouraging members to push their technical boundaries.\r\n" + //
                                                "•\tJoyful Discovery: Restoring the excitement and wonder inherent in the engineering process.\r\n" + //
                                                "")
                    .recentEvent("In one of the largest on-campus technical events of the year, Robogyan hosted the Internal Hackathon for SIH 2025. Over 1,100 students pushed their limits across two days of intense problem-solving and prototyping. The event was highly commended by our respected Director for its seamless execution and high-caliber output")
                    .achievements("The Result: 5 teams from our college advanced to the SIH National Finals - a success rate that surpassed several major IITs and solidified Robogyan's reputation as a powerhouse for practical engineering.")
    .images(List.of(
    "/Uploads/robogyan1.png",
    "/Uploads/robogyan2.png",
    "/Uploads/robogyan3.png",
    "/Uploads/robogyan4.png"
))
                    .instagram("robogyan")
                    .website("https://robogyan.tech/")
                    .youtube("robogyan_official")
                    .linkedin("robogyan")
                    .logoUrl("http://localhost:8080/Uploads/robogyan.png")
                    .admin(user)
.members(List.of(user))
                    .build();

            societyRepo.save(robogyan);
            System.out.println("✅ ROBOGYAN inserted");

            Society avant = Society.builder()
                    .name("AVANT GARDE")
                    .description("Society Description:\r\n" + //
                                                "Avant Garde- the official art society of ADGIPS, established in 2018, stands as a dynamic collective of creative individuals committed to visual expression, artistic exploration, and cultural engagement. Over the years, the society has cultivated a vibrant space where ideas take form through art, fostering a culture of creativity, collaboration, and experimentation.\r\n" + //
                                                "Avant Garde has consistently contributed to the college’s creative landscape through exhibitions, murals, artwalks, competitions, and collaborative projects, bringing art out of confined spaces and into shared experiences. One of its key highlights is Candescent, the society’s themed annual art fest hosted during the college fest, where artists come together to showcase their work and engage audiences through visual storytelling.\r\n" + //
                                                "The society plays an active role in shaping the aesthetic identity of major college events, including large-scale contributions to fest setups and thematic installations such as Utkarsh, where art becomes a medium to translate ideas into immersive environments.\r\n" + //
                                                "Beyond events, Avant Garde emphasizes hands-on learning, peer collaboration, and creative dialogue, encouraging members to experiment across mediums and develop their unique artistic voice. The society also takes pride in building a supportive and evolving community, where both experienced artists and beginners grow together.\r\n" + //
                                                "At its core, Avant Garde aims to nurture individuals who are not only skilled in their craft but also thoughtful, expressive, and capable of using art as a means to observe, interpret, and influence the world around them.\r\n" + //
                                                "")
                    .vision("To create a space where creativity thrives beyond boundaries, empowering individuals to explore, express, and evolve through art while building a culture that values originality, collaboration, and meaningful visual expression.")
                    .mission("At Avant Garde, we stand by the motto “If nothing else, believe in art.”. Our mission is to build an environment where art is experienced, not just observed. We focus on:\r\n" + //
                                                "•\tActive Creation: Encouraging members to practice, experiment, and produce consistently.\r\n" + //
                                                "•\tCreative Exploration: Pushing boundaries across styles, mediums, and ideas.\r\n" + //
                                                "•\tCollaborative Growth: Building a community where artists learn from and inspire each other.\r\n" + //
                                                "•\tMeaningful Expression: Using art as a tool to communicate, question, and connect.\r\n" + //
                                                "")
                    .recentEvent("In one of the most visually immersive and large-scale creative contributions to the college’s annual fest, Utkarsh 2026, Avant Garde played a central role in bringing the fest theme “Virasat se Vikas Tak – Evolution Through Heritage” to life. Through curated exhibitions, installationsand aesthetic design across key spaces on campus, the society transformed ideas into tangible visual experiences.\r\n" + //
                                                "\r\n" + //
                                                "The highlight was Candescent, the society’s themed exhibition, where artists showcased their work as part of a cohesive narrative aligned with the fest theme. This time around the theme for Candescent was “Retro” which led to a special exhibition of “Stranger Things”. The exhibition witnessed a footfall of over 300 visitors, reflecting strong engagement and interest from across the campus. Alongside this, Avant Garde also organized multiple art competitions, providing a platform for students to engage, create, and express their interpretations of the theme.\r\n" + //
                                                "Despite tight timelines and large-scale coordination, the execution was carried out seamlessly, reflecting strong teamwork, creativity, and planning. The society’s efforts were widely appreciated for enhancing the overall fest experience and establishing a distinct artistic presence across the campus.\r\n" + //
                                                "")
                    .achievements("Avant Garde successfully delivered a cohesive visual identity for Utkarsh, engaged a wide audience through its exhibition and events, and reinforced its position as a key driver of artistic expression and cultural engagement within the college.")
                    .instagram("avantgarde.adgips")
      .images(List.of(
    "/Uploads/avant1.png",
    "/Uploads/avant2.png"
))
.logoUrl("/Uploads/avant.png")
                    .logoUrl("http://localhost:8080/Uploads/avant.png")
                    .admin(user)
                    .members(List.of(user))
                    .build();

            societyRepo.save(avant);
            System.out.println("✅ AVANT inserted");

            String[] images = {
                    "https://picsum.photos/200?random=1",
                    "https://picsum.photos/200?random=2",
                    "https://picsum.photos/200?random=3",
                    "https://picsum.photos/200?random=4"
            };

            String randomImage = images[(int) (Math.random() * images.length)];

          Society confluenz = Society.builder()
    .name("CONFLUENZ")

    .description(
        "Confluenz — the official photography society of ADGIPS, founded in 2015 — is one of the most recognized and respected creative communities within the college, with photography at its core. While the society also thrives in cinematography and graphic design, its primary strength lies in capturing compelling visual narratives, making it the leading photography and media society on campus.\r\n" +
        "Over the years, Confluenz has built a strong presence across all major college events, playing a crucial role in documenting and elevating moments from cultural festivals, technical fests, sports meets, and flagship institutional programs. The society is deeply integrated into the college ecosystem, ensuring high-quality coverage and creative excellence at every level.\r\n" +
        "Structured across multiple departments including photography, cinematography, and graphics, Confluenz fosters a collaborative and hands-on environment. Through workshops, real-time event exposure, and continuous creative practice, members sharpen both technical skills and artistic vision. The society also organizes engaging photowalks across diverse locations, giving members the opportunity to explore, experiment, and capture unique perspectives beyond the campus.\r\n" +
        "Beyond internal contributions, Confluenz actively collaborates with numerous societies as an official media partner, strengthening inter-society engagement and expanding its creative footprint across the institution. These collaborations reflect the society’s reliability, professionalism, and creative impact.\r\n" +
        "At its core, Confluenz represents passion, precision, and storytelling driven by individuals who aim to create meaningful visual experiences through innovation, teamwork, and dedication.\r\n"
    )

    .vision(
        "To cultivate a dynamic community of creators who transform vision into reality through photography, filmmaking, and design — driven by curiosity, collaboration, and the pursuit of powerful visual storytelling."
    )

    .mission(
        "At Confluenz, we believe in learning through creation and expression. Our mission is to build a space where creativity meets real-world execution, empowering individuals to grow as confident visual storytellers. We focus on:\r\n" +
        "• Expressive Storytelling: Using photography and cinematography to capture emotions, perspectives, and moments that truly resonate.\r\n" +
        "• Creative Design Excellence: Crafting impactful visuals through graphics, branding, and well-curated social media aesthetics.\r\n" +
        "• Hands-on Learning: Encouraging every member to actively use the camera, explore tools, and learn by doing rather than just observing.\r\n" +
        "• Technical Mastery: Enabling members to gain proficiency in industry-standard tools such as Adobe Photoshop, Lightroom, Premiere Pro, After Effects, DaVinci Resolve, Canva, and more.\r\n" +
        "• Confidence & Skill Development: Building not just technical ability, but also creative confidence, teamwork, and a strong visual sense.\r\n"
    )

    .recentEvent(
        "Throughout the academic year, Confluenz has consistently played a central role in capturing and elevating the college’s biggest moments. From large-scale festivals to inter-college collaborations, the society has maintained a strong presence through its creative excellence and seamless execution.\r\n" +
        "At UTKARSH, the annual cultural fest of ADGIPS, Confluenz led the complete visual coverage across all days — documenting every event with professional precision, on-stage access, and high-quality storytelling that defined the fest’s digital and visual identity.\r\n" +
        "Beyond coverage, the society has also taken initiative in hosting impactful creative events. Confluenz successfully organized Chitraka, its flagship photography exhibition.\r\n" +
        "The society also collaborated with YAKSHAGAN for an on-the-spot filmmaking competition involving multiple colleges.\r\n" +
        "Confluenz has also represented the college at institutions like Miranda House, JIMS, Kirori Mal College, SGGSCC, and Deen Dayal Upadhyaya College — securing top positions.\r\n"
    )

    .achievements(
        "• Members of Confluenz have secured top positions in inter-college competitions across prestigious institutions.\r\n" +
        "• Built a strong reputation as a trusted media and photography society.\r\n" +
        "• Members gained proficiency in tools like Photoshop, Lightroom, Premiere Pro, After Effects, DaVinci Resolve, Canva.\r\n" +
        "• Conducted workshops and hands-on sessions for skill development.\r\n"
    )
       .images(List.of(
    "/Uploads/confluenz1.png"   // ✅ FIX NAME
))
    .instagram("confluenz")
    .logoUrl(randomImage)
    .admin(user)
    .members(List.of(user))
    .build();

societyRepo.save(confluenz);
System.out.println("✅ CONFLUENZ inserted");

            System.out.println("🔥 Data loading complete");
}
        System.out.println("🔥 Data loading complete");

        };
        }
}
