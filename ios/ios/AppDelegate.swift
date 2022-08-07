import SwiftUI
import WishmatKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    // Lazy so it doesn't try to initialize before startKoin() is called
    lazy var log = koin.loggerWithTag(tag: "AppDelegate")

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        startKoin()

        log.v(message: {"App Started"})

        return true
    }
}
