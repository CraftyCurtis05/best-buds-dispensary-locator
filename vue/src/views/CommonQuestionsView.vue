<!-- Common Questions Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Questions | Best Buds</title>

    <!-- Display Header Component -->    
    <header>
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="questions-body">

        <!-- Display Common Questions Main Content -->
        <main id="questions-main">

            <!-- Display Page Title -->
            <h1>Commonly Asked Questions About Cannabis</h1>

            <!-- Display Page Summary -->
             <p>***PAGE SUMMARY***</p>

            <!-- Display Smoking Qustions and Answers Information-->
             <section id="questions-smoking">
                <h2>Smoking Cannabis Q&A</h2>
                <p>***NEED SUMMARY***</p>

                <ol id="list">
                    <li>What is smoking cannabis?</li>
                    <ul id="sub-list">
                        <li>Smoking cannabis involves inhaling the smoke from burning cannabis flowers or concentrates.</li>
                        <li>This can be done using various methods, such as joints, blunts, pipes, or bongs.</li>
                    </ul>

                    <li>How does smoking cannabis affect the body?</li>
                    <ul id="sub-list">
                        <li>When smoked, cannabinoids like THC and CBD enter the bloodstream through the lungs, leading to effects such as relaxation, euphoria, altered perception, and increased appetite.</li>
                        <li>Smoking can also irritate the lungs and airways.</li>
                    </ul>

                    <li>How long do the effects of smoking cannabis last?</li>
                    <ul id="sub-list">
                        <li>The effects of smoking cannabis typically begin within minutes and can last from 1 to 3 hours, depending on the strain, dose, and individual tolerance.</li>
                    </ul>

                    <li>Is smoking cannabis harmful to the lungs?</li>
                    <ul id="sub-list">
                        <li>Smoking cannabis can irritate the lungs and airways, potentially leading to issues like bronchitis or chronic coughing.</li>
                        <li>It’s generally considered less harmful than smoking tobacco, but long-term use can still have adverse effects.</li>
                    </ul>

                    <li>What are the differences between smoking cannabis and using edibles?</li>
                    <ul id="sub-list">
                        <li>Smoking cannabis provides faster onset of effects (within minutes) and allows for more control over dosage.</li>
                        <li>Edibles take longer to kick in (30 minutes to 2 hours) and often produce longer-lasting effects.</li>
                        <li>Edibles also involve a different metabolism process.</li>
                    </ul>

                    <li>Can you get high from smoking cannabis?</li>
                    <ul id="sub-list">
                        <li>Yes, smoking cannabis will typically result in psychoactive effects due to the presence of THC.</li>
                        <li>The high can include feelings of euphoria, relaxation, and altered sensory perceptions.</li>
                    </ul>

                    <li>How can I minimize the health risks associated with smoking cannabis?</li>
                    <ul id="sub-list">
                        <li>Using a vaporizer, which heats cannabis to release cannabinoids without combustion, can reduce some of the harmful effects associated with smoking.</li>
                        <li>Additionally, avoiding deep inhalation and using clean, well-maintained smoking devices can help minimize risks.</li>
                    </ul>

                    <li>What are the best methods for smoking cannabis?</li>
                    <ul id="sub-list">
                        <li>Common methods include joints (rolled cannabis), blunts (cannabis rolled in cigar paper), pipes, and bongs (water pipes).</li>
                        <li>Each method has its own advantages and can affect the flavor and intensity of the smoke.</li>
                    </ul>

                    <li>How should I store cannabis for smoking?</li>
                    <ul id="sub-list">
                        <li>Store cannabis in an airtight container in a cool, dark place to preserve its potency and flavor.</li>
                        <li>Avoid exposing it to excessive light, heat, or moisture.</li>
                    </ul>

                    <li>Is it possible to smoke cannabis and not get high?</li>
                    <ul id="sub-list">
                        <li>Yes, if you consume cannabis with very low THC content or if you have developed a high tolerance, the psychoactive effects may be minimal or not noticeable.</li>
                    </ul>

                    <li>Can smoking cannabis affect mental health?</li>
                    <ul id="sub-list">
                        <li>For some individuals, especially those with a predisposition to mental health issues, smoking cannabis can exacerbate symptoms of anxiety, paranoia, or psychosis.</li>
                        <li>It’s important to be aware of how cannabis affects you personally.</li>
                    </ul>

                    <li>How can I manage the smell of cannabis smoke?</li>
                    <ul id="sub-list">
                        <li>The smell of cannabis smoke can be reduced by using a vaporizer, smoking in a well-ventilated area, or using odor-neutralizing products.</li>
                        <li>Scented candles or air purifiers can also help.</li>
                    </ul>

                    <li>Can I drive after smoking cannabis?</li>
                    <ul id="sub-list">
                        <li>Driving under the influence of cannabis is illegal in many places and can impair your reaction times and judgment.</li>
                        <li>It’s safest to avoid driving until you are fully sober.</li>
                    </ul>

                    <li>Are there legal issues associated with smoking cannabis?</li>
                    <ul id="sub-list">
                        <li>The legality of smoking cannabis varies by location.</li>
                        <li>In places where it is legal, there are often regulations regarding where you can smoke and how much you can possess.</li>
                        <li>Always check local laws to ensure compliance by checking out our <router-link v-bind:to="{ name:'legality' }">state law map</router-link>.</li>
                    </ul>

                    <li>How to inhale smoke for the first time?</li>
                    <ul id="sub-list">
                        <li>If you are new to smoking, it may be difficult to inhale the smoke properly.</li>
                        <li>Start by taking small, shallow breaths.</li>
                        <li>Don't try to inhale too much smoke at once.</li>
                        <li>Hold the smoke in your lungs briefly before exhaling.</li>
                        <li>Practice inhaling and exhaling with a clean pipe or bong before you smoke cannabis.</li>
                    </ul>

                    <li>Does coughing get you higher?</li>
                    <ul id="sub-list">
                        <li>Coughing does not get you higher.</li>
                        <li>In fact, it can actually make you feel less high.</li>
                        <li>When you cough, you are expelling the smoke from your lungs before it has a chance to be absorbed into your bloodstream.</li>
                    </ul>

                    <li>Does breathing deeper get you higher?</li>
                    <ul id="sub-list">
                        <li>Breathing deeper will not get you higher, but it can help you to absorb the smoke more efficiently.</li>
                        <li>When you breathe deeply, you are taking in more oxygen, which helps to carry the THC (the active ingredient in cannabis) into your bloodstream.</li>
                    </ul>

                    <li>What is better for first time cannabis use?</li>
                    <ul id="sub-list">
                        <li> Please check out our <router-link v-bind:to="{ name:'strainguide'}"> Strain Guide </router-link> for information.</li>
                    </ul>

                    <li>What are some tips for a better smoking experience?</li>
                    <ul id="sub-list">
                        <li>Use a clean pipe or bong.</li>
                        <li>Grind the cannabis finely.</li>
                        <li>Light the bowl evenly.</li>
                        <li>Inhale slowly and deeply.</li>
                        <li>Don't hold the smoke in your lungs for too long.</li>
                        <li>Exhale the smoke slowly.</li>
                        <li>Drink plenty of water.</li>
                        <li>Stay hydrated.</li>
                    </ul>
                </ol>    
            </section>

            <section id="questions-edibles">
                <h2>Cannabis Edibles Q&A</h2>
                <p>***NEED SUMMARY***</p>

                <ol id="list">
                    <li>What are cannabis edibles?</li>
                    <ul id="sub-list">
                        <li>Cannabis edibles are food products infused with cannabinoids, such as THC (tetrahydrocannabinol) and CBD (cannabidiol).</li>
                        <li>They come in various forms like gummies, brownies, chocolates, or beverages.</li>
                    </ul>

                    <li>How do cannabis edibles work?</li>
                    <ul id="sub-list">
                        <li>When you consume an edible, it passes through your digestive system and is metabolized by the liver.</li>
                        <li>The liver converts THC into a more potent form, which can lead to more intense effects compared to other methods of consumption.</li>
                    </ul>

                    <li>How long does it take for edibles to kick in?</li>
                    <ul id="sub-list">
                        <li>Edibles can take anywhere from 30 minutes to 2 hours to take effect, depending on factors like metabolism, the contents of the edible, and whether you have eaten recently.</li>
                        <li>It’s important to be patient and not take more before the effects are fully felt.</li>
                    </ul>

                    <li>How much should I start with?</li>
                    <ul id="sub-list">
                        <li>If you’re new to edibles, it’s best to start with a low dose, typically 5 to 10 milligrams of THC.</li>
                        <li>You can always take more later if needed, but starting small helps prevent overwhelming effects.</li>
                    </ul>

                    <li>What are the common effects of cannabis edibles?</li>
                    <ul id="sub-list">
                        <li>Effects can include relaxation, euphoria, altered perception of time, and increased appetite.</li>
                        <li>Some people may also experience anxiety or paranoia, especially with higher doses or in unfamiliar situations.</li>
                    </ul>

                    <li>Can I overdose on cannabis edibles?</li>
                    <ul id="sub-list">
                        <li>While it's unlikely to be life-threatening, consuming too much can lead to unpleasant effects like severe anxiety, paranoia, or confusion.</li>
                        <li>Always start with a low dose and wait for the effects to fully manifest before consuming more.</li>
                    </ul>

                    <li>How long do the effects last?</li>
                    <ul id="sub-list">
                        <li>The effects of cannabis edibles can last between 4 to 12 hours, with the peak effects occurring 2 to 4 hours after consumption.</li>
                        <li>The duration can vary based on individual metabolism and the dose.</li>
                    </ul>

                    <li>What should I do if I feel too high?</li>
                    <ul id="sub-list">
                        <li>If you’ve consumed too much and feel uncomfortable, try to stay calm.</li>
                        <li>Drinking water, resting in a comfortable environment, and eating a light snack can help.</li>
                        <li>CBD might help counteract some of the psychoactive effects of THC.</li>
                    </ul>
                    
                    <li>Are edibles legal?</li>
                    <ul id="sub-list">
                        <li>The legality of cannabis edibles varies by location.</li>
                        <li>In places where cannabis is legal, edibles are typically regulated and available for purchase.</li>
                        <li>Always check local laws to ensure compliance by using our <router-link v-bind:to="{ name:'legality' }">state law map</router-link>.</li>
                    </ul>

                    <li>Can edibles be made at home?</li>
                    <ul id="sub-list">
                        <li>Yes, you can make cannabis edibles at home using cannabis-infused oils or butters.</li>
                        <li>However, homemade edibles can be difficult to dose accurately, so it's important to be cautious with amounts.</li>
                    </ul>

                    <li>How should I store edibles?</li>
                    <ul id="sub-list">
                        <li>Store edibles in a cool, dry place, and keep them out of reach of children and pets.</li>
                        <li>Proper labeling can help avoid accidental consumption.</li>
                    </ul>

                    <li>Can I mix edibles with alcohol?</li>
                    <ul id="sub-list">
                        <li>Combining cannabis edibles with alcohol can amplify effects and increase the risk of unpleasant experiences.</li>
                        <li>It's generally advisable to avoid mixing the two until you understand how each affects you individually.</li>
                    </ul>
                </ol>
            </section>

            <section id="questions-cannabis">
                <h2>Cannabis Q&A</h2>
                <p>***NEED SUMMARY***</p>

                <ol id="list">
                    <li>What is cannabis?</li>
                    <ul id="sub-list">
                        <li>Cannabis is a plant genus that includes various species, such as Cannabis sativa, Cannabis indica, and Cannabis ruderalis.</li>
                        <li>It has been used for thousands of years for medicinal, recreational, and industrial purposes.</li>
                    </ul>

                    <li>What are the main components of cannabis?</li>
                    <ul id="sub-list">
                        <li>The two primary cannabinoids in cannabis are THC (tetrahydrocannabinol) and CBD (cannabidiol).</li>
                        <li>THC is responsible for most of the psychoactive effects, while CBD is known for its potential therapeutic benefits without causing a high.</li>
                    </ul>

                    <li>What are the different ways to consume cannabis?</li>
                    <ul id="sub-list">
                        <li>Smoking:</li>
                        <span>Using joints, blunts, pipes, or bongs.</span>
                        <li>Vaporizing:</li>
                        <span>Using a vaporizer to heat cannabis without burning it.</span>
                        <li>Edibles:</li>
                        <span>Consuming cannabis-infused foods or beverages.</span>
                        <li>Tinctures:</li>
                        <span>Using liquid extracts taken under the tongue.</span>
                        <li>Topicals:</li>
                        <span>Applying cannabis-infused creams or balms to the skin.</span>
                        <li>Concentrates:</li>
                        <span>Consuming highly concentrated forms of cannabis, such as oils, waxes, or shatter.</span>
                    </ul>

                    <li>What are the effects of cannabis?</li>
                    <ul id="sub-list">
                        <li>The effects of cannabis can vary depending on the strain, dosage, and individual.</li>
                        <li>Common effects include relaxation, euphoria, altered perception of time, increased appetite, and enhanced sensory experiences.</li>
                        <li>It can also cause dry mouth, red eyes, and sometimes anxiety or paranoia.</li>
                    </ul>

                    <li>How does cannabis affect the brain?</li>
                    <ul id="sub-list">
                        <li>Cannabis interacts with the endocannabinoid system in the brain, primarily affecting areas related to pleasure, memory, and movement.</li>
                        <li>THC binds to cannabinoid receptors, leading to its psychoactive effects.</li>
                    </ul>

                    <li>Can cannabis be addictive?</li>
                    <ul id="sub-list">
                        <li>Cannabis has a lower potential for addiction compared to substances like nicotine or opioids, but it is possible to develop a dependence or addiction.</li>
                        <li>Approximately 9% of users may develop a cannabis use disorder, with the risk increasing with frequent use.</li>
                    </ul>

                    <li>Is cannabis legal?</li>
                    <ul id="sub-list">
                        <li>The legality of cannabis varies by country and region.</li>
                        <li>In some places, it is legal for both recreational and medicinal use, while in others, it may be legal only for medical purposes or illegal altogether.</li>
                        <li>Always check local laws to ensure compliance by using our <router-link v-bind:to="{ name:'legality' }">state law map</router-link>.</li>
                    </ul>

                    <li>What are the medical uses of cannabis?</li>
                    <ul id="sub-list">
                        <li>Cannabis is used to treat a variety of conditions, including chronic pain, nausea, epilepsy, multiple sclerosis, and certain types of cancer-related symptoms.</li>
                        <li>CBD, in particular, has shown promise in treating conditions like anxiety and epilepsy.</li>
                    </ul>

                    <li>How does cannabis affect driving?</li>
                    <ul id="sub-list">
                        <li>Cannabis impairs motor skills, coordination, and reaction times, making it unsafe to drive under its influence.</li>
                        <li>Many regions have strict laws against driving while impaired by cannabis, similar to alcohol.</li>
                    </ul>

                    <li>What are cannabis strains, and how do they differ?</li>
                    <ul id="sub-list">
                        <li>Sativa:</li>
                        <span>Often associated with energizing and uplifting effects.</span>
                        <li>Indica:</li>
                        <span>Typically provides relaxing and sedative effects.</span>
                        <li>Hybrid:</li>
                        <span>A mix of both sativa and indica, combining effects from both types.</span>
                    </ul>

                    <li>How can I store cannabis properly?</li>
                    <ul id="sub-list">
                        <li>Store cannabis in an airtight container in a cool, dark place to maintain its potency and flavor.</li>
                        <li>Avoid exposing it to excessive light, heat, or moisture.</li>
                    </ul>

                    <li>What are terpenes, and why are they important?</li>
                    <ul id="sub-list">
                        <li>Terpenes are aromatic compounds found in cannabis (and other plants) that contribute to the plant's scent and flavor.</li>
                        <li>They may also influence the effects of different strains.</li>
                        <li>For example, limonene has a citrus aroma and may have mood-enhancing effects, while myrcene has a musky smell and may contribute to relaxing effects.</li>
                    </ul>

                    <li>Can cannabis interact with other medications?</li>
                    <ul id="sub-list">
                        <li>Yes, cannabis can interact with certain medications, potentially affecting their efficacy or increasing side effects.</li>
                        <li>Always consult with a healthcare provider before using cannabis if you are on medication.</li>
                    </ul>

                    <li>What is CBD, and how does it differ from THC?</li>
                    <ul id="sub-list">
                        <li>CBD (cannabidiol) is a non-psychoactive cannabinoid that does not produce a high.</li>
                        <li>It is often used for its potential therapeutic benefits, such as reducing anxiety or pain, without the intoxicating effects associated with THC (tetrahydrocannabinol).</li>
                    </ul>

                    <li>How can I find the right dosage?</li>
                    <ul id="sub-list">
                        <li>Finding the right dosage of cannabis depends on the method of consumption, the strain, and individual tolerance.</li>
                        <li>Start with a low dose and gradually increase until you find the right amount for your needs.</li>
                        <li>Consult with a healthcare professional for personalized advice.</li>
                    </ul>
                </ol>
            </section>

            <section id="questions-vaporizing">
                <h2>Vaporizing Cannabis Q&A</h2>
                <p>***NEED SUMMARY***</p>

                <ol id="list">
                    <li>What is vaporizing cannabis?</li>
                    <ul id="sub-list">
                        <li>Vaporizing cannabis involves heating it to a temperature where cannabinoids and terpenes are released as vapor, but not hot enough to burn the plant material.</li>
                        <li>This method is considered a healthier alternative to smoking because it reduces the production of harmful byproducts like tar and carcinogens.</li>
                    </ul>

                    <li>How does vaporizing differ from smoking?</li>
                    <ul id="sub-list">
                        <li>Vaporizing heats cannabis at a lower temperature than smoking, avoiding combustion and producing fewer harmful chemicals.</li>
                        <li>This can make vaporizing a cleaner and potentially less irritating method for consuming cannabis.</li>
                    </ul>

                    <li>What are the benefits of vaporizing cannabis?</li>
                    <ul id="sub-list">
                        <li>Reduced Harm:</li>
                        <span>Vaporizing avoids combustion, minimizing exposure to harmful toxins and irritants.</span>
                        <li>Efficiency:</li>
                        <span>Vaporizers can be more efficient in extracting cannabinoids and terpenes, potentially providing more potent effects from less material.</span>
                        <li>Taste and Aroma:</li>
                        <span>Vaporizing often preserves the flavor and aroma of cannabis better than smoking.</span>
                    </ul>

                    <li>How do I use a vaporizer?</li>
                    <ul id="sub-list">
                        <li>Load the Chamber:</li>
                        <span>Add ground cannabis or concentrates to the vaporizer’s chamber or bowl.</span>
                        <li>Set the Temperature:</li>
                        <span>Adjust the temperature settings based on your preference and the type of cannabis you’re using. Lower temperatures (around 330-350°F) preserve terpenes and provide a milder experience, while higher temperatures (350-400°F) extract more cannabinoids and provide stronger effects.</span>
                        <li>Inhale the Vapor:</li>
                        <span>Once the vaporizer has reached the desired temperature, inhale the vapor through the mouthpiece.</span>
                    </ul>

                    <li>What types of vaporizers are available?</li>
                    <ul id="sub-list">
                        <li>Portable Vaporizers:</li>
                        <span>Compact and battery-operated, suitable for on-the-go use. Examples include the Pax and Mighty.</span>
                        <li>Desktop Vaporizers:</li>
                        <span>Larger, plug-in devices with precise temperature control, designed for home use. Examples include the Volcano and Arizer Extreme Q.</span>
                        <li>Vape Pens:</li>
                        <span>Slim and discreet, designed for concentrates or vape cartridges with pre-filled cannabis extracts.</span>
                    </ul>

                    <li>How do I clean and maintain a vaporizer?</li>
                    <ul id="sub-list">
                        <li>Regular cleaning is important for maintaining vapor quality and device performance:</li>
                        <li>Disassemble the Device:</li>
                        <span>Remove any removable parts like the mouthpiece or chamber.</span>
                        <li>Clean Components:</li>
                        <span>Use a brush, alcohol wipes, or a cleaning solution specific to the vaporizer. Avoid submerging electrical components in liquid.</span>
                        <li>Reassemble and Dry:</li>
                        <span>Ensure all parts are completely dry before reassembling and using the device.</span>
                    </ul>

                    <li>What temperature is best for vaporizing cannabis?</li>
                    <ul id="sub-list">
                        <li>Low Temperature (330-350°F):</li>
                        <span>Preserves terpenes and provides a more flavorful, milder experience. Ideal for enjoying the nuanced flavors and aromas.</span>
                        <li>Medium Temperature (350-370°F):</li>
                        <span>Balances flavor and potency, suitable for most users.</span>
                        <li>High Temperature (370-400°F):</li>
                        <span>Extracts more cannabinoids, providing stronger effects but can also produce harsher vapor.</span>
                    </ul>

                    <li>Can vaporizing cannabis make me high?</li>
                    <ul id="sub-list">
                        <li>Yes, vaporizing cannabis will produce the psychoactive effects of THC, just as smoking or consuming edibles would.</li>
                        <li>The effects can vary based on the strain, dosage, and individual tolerance.</li>
                    </ul>

                    <li>How can I avoid a dry mouth when vaporizing?</li>
                    <ul id="sub-list">
                        <li>Dry mouth is a common side effect of cannabis use.</li>
                        <li>To mitigate it, drink plenty of water before, during, and after vaporizing.</li>
                        <li>Keeping hydrated can help alleviate the sensation.</li>
                    </ul>

                    <li>Are there any health risks associated with vaporizing?</li>
                    <ul id="sub-list">
                        <li>While vaporizing is generally considered less harmful than smoking, it is not entirely risk-free.</li>
                        <li>Some risks include potential irritation to the respiratory system and exposure to harmful chemicals if the vaporizer is not properly maintained.</li>
                    </ul>

                    <li>How do I choose the right vaporizer for me?</li>
                    <ul id="sub-list">
                        <li>Consider factors such as:</li>
                        <li>Portability vs. Stationary Use:</li>
                        <span>Decide if you need a portable device or one for home use.</span>
                        <li>Type of Material:</li>
                        <span>Ensure the vaporizer can handle the type of cannabis you intend to use (e.g., flower, concentrates).</span>
                        <li>Budget:</li>
                        <span>Vaporizers vary in price, so choose one that fits your budget and needs.</span>
                        <li>Features:</li>
                        <span>Look for features like temperature control, battery life, and ease of cleaning.</span>
                    </ul>

                    <li>Can I use essential oils or other substances in a vaporizer?</li>
                    <ul id="sub-list">
                        <li>It’s important to use only substances intended for vaporization in your device.</li>
                        <li>Using essential oils or other substances not designed for vaporizing can damage the device and may be harmful to inhale.</li>
                    </ul>

                    <li>How do I know if my vaporizer is working properly?</li>
                    <ul id="sub-list">
                        <li>Check for consistent vapor production and ensure the device heats up to the set temperature.</li>
                        <li>If you notice a lack of vapor, unusual tastes, or malfunctions, it may be time for maintenance or troubleshooting.</li>
                    </ul>
                </ol>
            </section>

            <section id="questions-wax">
                <h2>Cannabis Wax Q&A</h2>
                <p>***NEED SUMMARY***</p>

                <ol id="list">
                    <li>What is cannabis wax?</li>
                    <ul id="sub-list">
                        <li>Cannabis wax is a type of cannabis concentrate known for its sticky, waxy consistency.</li>
                        <li>It’s made by extracting cannabinoids and terpenes from cannabis plants, resulting in a highly potent product with a high THC or CBD content.</li>
                    </ul>

                    <li>How is cannabis wax made?</li>
                    <ul id="sub-list">
                        <li>Cannabis wax is typically made using extraction methods like butane extraction or CO2 extraction.</li>
                        <li>These processes involve dissolving the cannabinoids and terpenes from cannabis plant material using a solvent, then purging the solvent to leave behind a concentrated, waxy substance.</li>
                    </ul>

                    <li>What are the effects of using cannabis wax?</li>
                    <ul id="sub-list">
                        <li>Cannabis wax is highly concentrated, so its effects are more potent compared to regular cannabis flower.</li>
                        <li>Users may experience strong psychoactive effects, including euphoria, relaxation, and heightened sensory perception.</li>
                        <li>It’s important to use it cautiously due to its high potency.</li>
                    </ul>

                    <li>How do you consume cannabis wax?</li>
                    <ul id="sub-list">
                        <li>Dabbing:</li>
                        <span>Using a dab rig, you heat a nail or banger and then place a small amount of wax on it to vaporize and inhale.</span>
                        <li>Vaporizers:</li>
                        <span>Some vaporizers are designed for concentrates and can be used to vaporize wax.</span>
                        <li>Combining with Flower:</li>
                        <span>Wax can be added to cannabis flower in a pipe or joint for a more potent effect.</span>
                    </ul>

                    <li>What is dabbing?</li>
                    <ul id="sub-list">
                        <li>Dabbing is a method of consuming cannabis concentrates, including wax, where you heat a surface (usually a nail or banger) and then apply a small amount of concentrate to it.</li>
                        <li>The concentrate vaporizes instantly and is inhaled through a dab rig.</li>
                    </ul>

                    <li>What is a dab rig?</li>
                    <ul id="sub-list">
                        <li>A dab rig is a specialized piece of equipment used for consuming cannabis concentrates.</li>
                        <li>It typically includes a glass piece, a nail or banger (which is heated), and a mouthpiece.</li>
                        <li>The concentrate is applied to the hot nail or banger, producing vapor that is inhaled.</li>
                    </ul>

                    <li>What are the benefits of using cannabis wax?</li>
                    <ul id="sub-list">
                        <li>Potency:</li>
                        <span>Wax is highly concentrated, providing strong effects from a small amount.</span>
                        <li>Flavor:</li>
                        <span>Concentrates like wax can retain a lot of the original flavor and aroma of the cannabis strain.</span>
                        <li>Efficiency:</li>
                        <span>Wax allows for precise dosing and can be more efficient in delivering cannabinoids compared to traditional methods.</span>
                    </ul>

                    <li>Are there any health risks associated with using cannabis wax?</li>
                    <ul id="sub-list">
                        <li></li>
                        <span></span>
                        <li></li>
                        <span></span>
                        <li></li>
                        <span></span>
                    </ul>

                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>

                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>

                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>

                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>

                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>

                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>

                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>
                </ol>
            </section>

            <section id="questions-topicals">
                <h2></h2>
                <p></p>

                <ol id="list">
                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>
                </ol>
            </section>

            <section id="questions-tincture">
                <h2></h2>
                <p></p>

                <ol id="list">
                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>
                </ol>
            </section>

            <section id="questions-cbd">
                <h2></h2>
                <p></p>

                <ol id="list">
                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>
                </ol>
            </section>

            <section id="questions-delta9">
                <h2></h2>
                <p></p>

                <ol id="list">
                    <li></li>
                    <ul id="sub-list">
                        <li></li>
                    </ul>
                </ol>
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
            <QuoteComponent/>
        </div>  

    </body>

     <!-- Display Footer Component -->
    <footer>
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "CommonQuestions",
    components: { 
        Header, 
        StrainGuideVisit, 
        ArticlesVisit, 
        QuoteComponent, 
        Footer 
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#common-questions-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#common-questions-main {
    margin: 4vw;
}

h1,
h2,
p,
#strain-guide-visit,
#articles-visit {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

h2 {
  font-size: 1.3rem;
  padding-top: 2rem;
}

p {
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}

ul {
    font-size: 1.15rem;
}

li {
    padding: .15vw;
}

h4,
h5 {
    font-size: 1rem;
    margin: .1vw;
}

#strain-guide,
#articles-visit {
    padding: 1vw;
}
</style>