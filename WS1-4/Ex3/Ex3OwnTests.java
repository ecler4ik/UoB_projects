
import org.junit.Assert;
import org.junit.Test;

public class Ex3OwnTests {
	/**
	 * Own junit tests to check if the web crawler works properly splitting urls
	 * and then collecting them to ArrayList
	 * 
	 * @author Valeriya Yashina
	 */
    @Test
    public void collectUrls1() {

        String[] urlsExpected = {"about.html", "output.html",
                "http://ec.europa.eu/research/mariecurieactions/about-mca/actions/iif/",
                "http://www.fhss.uaeu.ac.ae/linguistics/", "http://www.cs.bham.ac.uk/useful-contacts/",
                "https://www.northumbria.ac.uk/about-us/news-events/events/2015/07/iclc-13-the-13th-international-cognitive-linguistics-conference/",
                "http://www.cs.bham.ac.uk/~gargetad/AISB-CP-2015.html",
                "http://www.cs.bham.ac.uk/~gargetad/figurative-language-workshop-birmingham-2014.html",
                "http://naacl.org/naacl-hlt-2015/", "http://naacl.org/naacl-hlt-2015/",
                "http://naacl.org/naacl-hlt-2015/", "http://www.cs.bham.ac.uk/~gargetad/corpora.html"};

        Assert.assertArrayEquals(urlsExpected, WebCrawler.collectUrls("https://www.cs.bham.ac.uk/~gargetad/").toArray());
    }

    @Test
    public void collectUrls2() {

        String[] urlsExpected = {"http://www.bham.ac.uk/", "http://www.cs.bham.ac.uk/", "http://catmkennedy.com/",
                "reports.html", "pub.html", "#B", "http://www.eucognition.org/", "http://www.jmir.org/2012/3/e80/",
                "http://sis.uncc.edu/", "http://www.gtheodoropoulos.com/", "http://www.publicpolicy.bham.ac.uk/",
                "http://www.esrc.ac.uk/ESRCInfoCentre/index.aspx",
                "http://www.cs.bham.ac.uk/research/cogaff/kennedy-phd-thesis.pdf",
                "http://www.cs.bham.ac.uk/~axs/cog_affect/sim_agent.html"};

        Assert.assertArrayEquals(urlsExpected, WebCrawler.collectUrls("https://www.cs.bham.ac.uk/~cmk/").toArray());
    }

    @Test
    public void collectUrls3() {

        String[] urlsExpected = {};

        Assert.assertArrayEquals(urlsExpected, WebCrawler.collectUrls("http").toArray());
    }

}
