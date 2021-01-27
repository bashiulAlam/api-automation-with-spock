

/**
 * Created by Sabab on 24-Jan-21.
 */

runner {

    def withService = false
    if (withService.equals(true)) {
//        exclude IntegrationTestSpec
    } else {
        exclude {
            //baseClass AspTestSpec
            //baseClass SyncTestSpec
            //baseClass IntegrationTestSpec
            //baseClass AServiceDefinitionSpec
        }
    }
}