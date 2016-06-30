package httpclient

import groovy.json.JsonSlurper

/**
 * Created by stephenokennedy on 28/06/2016.
 * Simple script that does some list comprehensions on a petition for a second EU referundum in the UK
 */
class EPetitions extends Script{

    private
    def connectToApi(){
        String result = new URL("https://petition.parliament.uk/petitions/131215.json").text
        return new JsonSlurper().parseText(result)
    }

    def getCountyData(object){
        return object.data
    }
    @Override
    Object run() {
        def petition = connectToApi()

        //Lowest Signature Count
        def initialCountry = petition.data.attributes.signatures_by_country[0]
        def countryWithLowestSignatures = petition.data.attributes.signatures_by_country.inject (initialCountry) { prev,curr -> curr.signature_count < prev.signature_count? curr:prev }
        println(countryWithLowestSignatures)

        //Sort The Constituencies
        def sortedConstituencies = quickSort(petition.data.attributes.signatures_by_constituency)
        //Constituencies with the least support
        println(sortedConstituencies.take(4))
        //Constituencies with the most support
        println(sortedConstituencies.takeRight(5))

    }

    def quickSort(List arr){
        if (arr.size() == 0) return arr
        def x = arr.pop()
        List lQuickSort = quickSort(arr.findAll {a -> x.signature_count > a.signature_count})
        List rQuickSort = quickSort(arr.findAll {a -> x.signature_count <= a.signature_count})
        return lQuickSort + [x] + rQuickSort
    }
}
