package factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static String browserName = "chrome";

    private static ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> threadLocalBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
    private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return threadLocalPlaywright.get();
    }

    public static BrowserContext getBrowserContext() {
        return threadLocalBrowserContext.get();
    }

    public static Browser getBrowser() {
        return threadLocalBrowser.get();
    }

    public static Page getPage() {
        if (threadLocalPage.get() == null) {
            initializePage();
        }
        return threadLocalPage.get();
    }

    public static void closePlaywright() {
        if (threadLocalPage.get() != null) {
            threadLocalPage.get().context().browser().close();
            threadLocalPlaywright.get().close();
        }
    }

    public static Page initializePage() {
        threadLocalPlaywright.set(Playwright.create());
        switch (browserName.toLowerCase()) {
            case "chromium":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                threadLocalBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)));
                break;
            case "chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50));
                threadLocalBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50)));
                break;
            case "edge":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50));
                threadLocalBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50)));
                break;
            case "firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                threadLocalBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)));
                break;
            case "safari":
                //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                threadLocalBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)));
                break;
            default:
                System.out.println("Invalid Browsername passed in Congig file.....");
        }

        //context = browser.newContext();
        threadLocalBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1366, 768)));
        //page = context.newPage();
        threadLocalPage.set(getBrowserContext().newPage());
        return getPage();
    }
}
