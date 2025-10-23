// Copyright 2025 Răzvan Roșu
// SPDX-License-Identifier: Apache-2.0

package red.razvan.restcountries.android.compose.app

import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.core.net.toUri
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import red.razvan.restcountries.android.compose.app.internal.screens.NavDestinations
import red.razvan.restcountries.android.compose.app.internal.screens.NavDestinations.CountryDetailsScreen.Companion.toDestination
import red.razvan.restcountries.android.compose.app.internal.screens.countries.CountriesScreen
import red.razvan.restcountries.android.compose.app.internal.screens.details.CountryDetailsScreen
import red.razvan.restcountries.android.compose.app.internal.screens.licenses.LicensesScreen
import red.razvan.restcountries.android.compose.design.RestCountriesTheme

internal object RestCountriesAppTestTags {
  const val COUNTRY_DETAILS_SCREEN = "country-details-screen"
  const val COUNTRIES_SCREEN = "countries-screen"
  const val LICENSES_SCREEN = "licenses-screen"
}

@Composable
fun RestCountriesApp(
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()
  val onNavigateUp: () -> Unit = {
    navController.popBackStack()
  }

  val context = LocalContext.current

  RestCountriesTheme {
    NavHost(
      modifier = modifier,
      navController = navController,
      startDestination = NavDestinations.CountriesScreen,
    ) {
      composable<NavDestinations.CountriesScreen> {
        CountriesScreen(
          onNavigateToCountryDetails = { id ->
            navController
              .navigate(route = id.toDestination())
          },
          onNavigateToLicenses = {
            navController
              .navigate(route = NavDestinations.LicensesScreen)
          },
          modifier = Modifier
            .testTag(RestCountriesAppTestTags.COUNTRIES_SCREEN),
        )
      }

      composable<NavDestinations.CountryDetailsScreen> { backStackEntry ->
        val destination = backStackEntry.toRoute<NavDestinations.CountryDetailsScreen>()

        CountryDetailsScreen(
          countryId = destination.countryId,
          onNavigateUp = onNavigateUp,
          modifier = Modifier
            .testTag(RestCountriesAppTestTags.COUNTRY_DETAILS_SCREEN),
        )
      }

      composable<NavDestinations.LicensesScreen> {
        LicensesScreen(
          onNavigateUp = onNavigateUp,
          onOpenUrl = { url ->
            CustomTabsIntent
              .Builder()
              .build()
              .launchUrl(context, url.toUri())
          },
          modifier = Modifier
            .testTag(RestCountriesAppTestTags.LICENSES_SCREEN),
        )
      }
    }
  }
}
