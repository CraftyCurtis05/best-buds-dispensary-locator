<!-- Privacy Policy View Display --->
<template>

  <!-- Browser Tab Title -->
  <title>Privacy Policy | Best Buds</title>

  <!-- Display Header Component -->
  <header id="top">
    <Header/>
  </header>

  <!-- Display View Body -->
  <body id="privacy-body">

    <!-- Display Body's Main Content -->
    <main id="privacy-main">

      <!-- Display Body Title -->
      <h1>Best Buds Privacy Policy</h1>

      <!-- Display View Jump Links Component -->
      <aside id="view-links">
        <ViewJumpLinks/>
      </aside>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>Effective Date: 9/24/2024</h2>
        <p>At Best Buds, we are committed to protecting your privacy. This Privacy Policy outlines how we collect, use, and safeguard your information when you use our website.</p>
        <h3></h3>
      </section>

      <!-- Display Privacy Policy Information -->
      <section id="privacy">

        <!-- Display Policy Component -->
        <!-- <article id="policy">***CREATE PRIVACY POLICY COMPONENT***</article> -->
        <h2>Effective Date: 9/20/2024</h2>
          <li>Information We Collect</li>
                <ul id="sub-list">
                    <li>Personal Information:</li>
                    <span>When you create an account, we may collect personal information such as your name, email address, and location.
                    </span>
                    <li>Usage Data:</li>
                    <span>We may collect information about how you access and use our website, including your IP address, browser type, pages viewed, and the time and date of your visits.</span>
                </ul>
          <li>How We Use Your Information</li>
                <ul id="sub-list">
                    <li>To create and manage your account.</li>
                    <li>To provide and maintain our services, including search functionality and saving your favorite dispensaries. </li>
                    <li>To send you newsletters, updates, and promotional content (if you have opted in). </li>
                    <li>To improve our website and enhance user experience. </li>
                    <li>To understand user behavior and preferences for analytics and research purposes.</li>
                    </ul>
          <li>Data Security</li>
                <ul id="sub-list">
                    <span>We take data security seriously and implement reasonable measures to protect your personal information. This includes encryption and secure server hosting. However, please be aware that no method of transmission over the Internet or method of electronic storage is 100% secure.</span></ul>   

          <li>Sharing Your Information</li>
                <ul id="sub-list">
                  <span>Best Buds does not sell, rent, or trade your personal information to third parties. We may share your information in the following situations:</span>
                  <li>Service Providers: We may employ third-party companies and individuals to facilitate our service, provide the service on our behalf, or perform service-related services (e.g., payment processing).</li>
                  <li>Legal Requirements: We may disclose your information if required to do so by law or in response to valid requests by public authorities.</li>
                  </ul>

          <li>Your Rights</li>
                <ul id="sub-list">
                  <span>You have the right to:</span>
                  <li>Access the personal information we hold about you.</li>
                  <li>Request correction of any inaccurate or incomplete information.</li>
                  <li>Delete your account and personal information upon request.</li>
                  <li>Opt out of receiving marketing communications at any time.</li>
                </ul>

          <li>Third-Party Links</li>
                <ul id="sub-list">
                  <span>Our website may contain links to third-party websites. We are not responsible for the privacy practices or the content of those websites. We encourage you to review the privacy policies of any third-party sites you visit.
                  </span>
                </ul>

          <li>Changes to this Privacy Policy</li>
                <ul id="sub-list">
                  <span>We may update our Privacy Policy from time to time. We will notify you of any changes by posting the new policy on this page. You are advised to review this Privacy Policy periodically for any changes.
                  </span>
                </ul>
        
          <li>Contact Us</li>
                <ul id="sub-list">
                  <span>If you have any questions about this Privacy Policy, please email us at ourbudsarebest@gmail.com. </span>
                  <span>Thank you for using Best Buds! We appreciate your trust and are dedicated to protecting your privacy. </span>
                </ul>
      </section>

    </main>

    <!-- Display Strain Guide Visit Component -->
    <section id="strain-guide-visit">
      <StrainGuideVisit/>
    </section>

    <!-- Display Articles Visit Component -->
    <section id="articles-visit">
      <ArticlesVisit/>
    </section>

    <!-- Display Quote Component -->
    <div id="quote">
      <Quote/>
    </div>  

  </body>

  <!-- Display Footer Component -->
  <footer id="bottom">
    <Footer/>
  </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import ViewJumpLinks from '@/components/ViewJumpLinks.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "PrivacyPolicyView",
  components: { 
    Header,
    ViewJumpLinks,
    StrainGuideVisit, 
    ArticlesVisit, 
    Quote, 
    Footer 
  }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#privacy-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#privacy-main {
  margin: 4vw;
}

h1,
#summary {
    text-align: center;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}
</style>