import com.github.javafaker.Faker

Faker faker = new Faker()

for(int i = 0 ; i < 100 ; i++) {
String randomFullNames = "${faker.name().firstName()} ${faker.name().firstName()} ${faker.name().lastName()}"
//println("Fake Name: " + randomFullNames)

def randomFullName = randomFullNames.replaceAll(/[^\p{L}\p{N}\s]/, '')
println(randomFullName)
}

faker.name().firstName()