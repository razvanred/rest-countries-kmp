// swift-tools-version: 6.0
import PackageDescription

#if TUIST
  import struct ProjectDescription.PackageSettings

  let packageSettings = PackageSettings(
    // Customize the product types for specific package product
    // Default is .staticFramework
    // productTypes: ["Alamofire": .framework,]
    productTypes: [:]
  )
#endif

let package = Package(
  name: "rest-countries",
  dependencies: [
    .package(url: "https://github.com/hmlongco/Factory.git", from: "2.5.3"),
  ]
)
