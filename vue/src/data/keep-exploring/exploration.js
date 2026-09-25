// Best Buds Keep Exploring content
export default {

    // Home
    home: {
        category: "Discover Best Buds",
        messages: [
            "There's more to discover than what's on the surface.",
            "Explore nearby dispensaries, learn something new, or see what's waiting in your Stash.",
            "Your Best Buds journey can start wherever curiosity takes you."
        ],
        nextRoute: "search",
        nextLabel: "Find Dispensaries Near You"
    },

    // Dispensary Locator
    search: {
        category: "Keep Discovering",
        messages: [
            "Your next discovery might be closer than you think.",
            "Finding a dispensary is easy. Remembering the good ones is even easier.",
            "See something worth coming back to? Save it for later."
        ],
        nextRoute: "saved-dispensaries",
        nextLabel: "View Saved Dispensaries"
    },

    // Saved Dispensaries
    "saved-dispensaries": {
        category: "Your Discoveries",
        messages: [
            "Good finds are worth remembering.",
            "Your saved dispensaries make it easy to return to places that caught your attention.",
            "You've found some places. Now see what else you've collected along the way."
        ],
        nextRoute: "my-stash",
        nextLabel: "Visit My Stash"
    },

    // Getting Started
    "tips-tricks": {
        category: "Know Your Buds",
        messages: [
            "A little knowledge can make every discovery more meaningful.",
            "Cannabis can seem complicated at first. Learning the basics makes everything else easier.",
            "Start with the basics, then follow whatever makes you curious."
        ],
        nextRoute: "products",
        nextLabel: "Explore Cannabis Products"
    },

    // Products
    products: {
        category: "Know Your Buds",
        messages: [
            "Flower, edibles, oils, tinctures, topicals, and concentrates each have different characteristics.",
            "Knowing what's out there makes exploring your options a little easier.",
            "Products are only part of the story. What makes cannabis different goes deeper."
        ],
        nextRoute: "strain-guide",
        nextLabel: "Explore Strains & Terpenes"
    },

    // Strains and Terpenes
    "strain-guide": {
        category: "Know Your Buds",
        messages: [
            "Every strain has a story. Cannabinoids and terpenes help tell it.",
            "Names are only the beginning. There's more behind what makes cannabis varieties different.",
            "Follow your curiosity. Aroma, cannabinoids, and terpenes can reveal a lot about the plant."
        ],
        nextRoute: "safety",
        nextLabel: "Explore Cannabis Safety"
    },

    // Safety
    safety: {
        category: "Good to Know",
        messages: [
            "Good decisions start with good information.",
            "Knowing what a product is only tells part of the story. Understanding safety matters too.",
            "Exploring responsibly means knowing what questions to ask."
        ],
        nextRoute: "questions",
        nextLabel: "Explore Common Questions"
    },

    // Common Questions
    questions: {
        category: "Stay Curious",
        messages: [
            "Good questions are one of the best ways to learn.",
            "Cannabis comes with plenty of questions. That's exactly why Best Buds keeps exploring them.",
            "One answer usually leads to another question. Keep going."
        ],
        nextRoute: "articles",
        nextLabel: "Read Best Buds Articles"
    },

    // Articles
    articles: {
        category: "Dig a Little Deeper",
        messages: [
            "Sometimes the interesting part starts after the quick answer.",
            "There's always another side of the plant worth learning about.",
            "You've explored the basics. Take a deeper look at the topics that interest you."
        ],
        nextRoute: "news",
        nextLabel: "See What's New"
    },

    // Legality
    legality: {
        category: "Know Before You Go",
        messages: [
            "Cannabis laws can differ depending on where you are.",
            "Knowing the rules is part of knowing the landscape.",
            "Learning what's legal is useful. Seeing what's around you can be the next step."
        ],
        nextRoute: "search",
        nextLabel: "Explore the Dispensary Locator"
    },

    // News
    news: {
        category: "Stay in the Know",
        messages: [
            "Cannabis keeps changing. Staying informed helps you keep up.",
            "New research, policies, products, and conversations continue to shape the cannabis landscape.",
            "Today's headline might become tomorrow's topic worth exploring."
        ],
        nextRoute: "articles",
        nextLabel: "Explore Best Buds Articles"
    },

    // Profile
    profile: {
        category: "Your Best Buds",
        messages: [
            "Your profile helps make Best Buds feel a little more like yours.",
            "Your home location, saved places, and discoveries all become part of your Best Buds experience.",
            "You've made Best Buds yours. See what you've collected along the way."
        ],
        nextRoute: "my-stash",
        nextLabel: "Visit My Stash"
    },

    // My Stash
    "my-stash": {
        category: "Your Best Buds Journey",
        messages: [
            "Every Drop tells a little piece of your Best Buds journey.",
            "Keep exploring. You never know where the next Drop might be hiding.",
            "Some discoveries leave something behind. 👀"
        ],
        nextRoute: "tips-tricks",
        nextLabel: "Keep Exploring Best Buds"
    },

    // Account Settings
    "account-settings": {
        category: "Make It Yours",
        messages: [
            "Your account keeps the practical stuff in one place.",
            "With the settings handled, you can get back to the interesting stuff.",
            "All set? There's plenty more growing around Best Buds."
        ],
        nextRoute: "home",
        nextLabel: "Return Home"
    }

};