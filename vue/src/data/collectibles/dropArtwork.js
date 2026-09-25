import firstContact
    from "../../assets/collectibles/01-first-contact.png";
import nightOwl
    from "../../assets/collectibles/02-night-owl.png";
import offTheMap
    from "../../assets/collectibles/03-off-the-map.png";
import explorer
    from "../../assets/collectibles/04-explorer.png";
import curator
    from "../../assets/collectibles/05-curator.png";
import stashed
    from "../../assets/collectibles/06-stashed.png";
import deepDive
    from "../../assets/collectibles/07-deep-dive.png";
import wellInformed
    from "../../assets/collectibles/08-well-informed.png";
import knowYourBuds
    from "../../assets/collectibles/09-know-your-buds.png";
import readTheLabel
    from "../../assets/collectibles/10-read-the-label.png";
import safetyFirst
    from "../../assets/collectibles/11-safety-first.png";
import clearHead
    from "../../assets/collectibles/12-clear-head.png";
import undiscovered
    from "../../assets/collectibles/13-undiscovered.png";
import theRegular
    from "../../assets/collectibles/14-the-regular.png";
import completionist
    from "../../assets/collectibles/15-completionist.png";
import theWholePicture
    from "../../assets/collectibles/16-the-whole-picture.png";

const dropArtwork = {
    "First Contact": firstContact,
    "Night Owl": nightOwl,
    "Off the Map": offTheMap,
    "Explorer": explorer,
    "Curator": curator,
    "Stashed": stashed,
    "Deep Dive": deepDive,
    "Well Informed": wellInformed,
    "Know Your Buds": knowYourBuds,
    "Read the Label": readTheLabel,
    "Safety First": safetyFirst,
    "Clear Head": clearHead,
    "Undiscovered": undiscovered,
    "The Regular": theRegular,
    "Completionist": completionist,
    "The Whole Picture": theWholePicture
};

// Get the artwork for a Best Buds Drop
export function getDropArtwork(
    collectibleName
) {

    return dropArtwork[
        collectibleName
    ] || null;

}