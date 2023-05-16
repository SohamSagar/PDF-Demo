package com.example.pdf_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val wv=findViewById<WebView>(R.id.wv)
        val mimeType = "text/html"
        val encoding = "UTF-8"
        val html =
            "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "\t<head>\n" +
                    "\t\t<meta charset=\"utf-8\" />\n" +
                    "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                    "\n" +
                    "\t\t<title>A simple, clean, and responsive HTML invoice template</title>\n" +
                    "\n" +
                    "\t\t<!-- Favicon -->\n" +
                    "\t\t<link rel=\"icon\" href=\"./images/favicon.png\" type=\"image/x-icon\" />\n" +
                    "\n" +
                    "\t\t<!-- Invoice styling -->\n" +
                    "\t\t<style>\n" +
                    "\t\t\tbody {\n" +
                    "\t\t\t\tfont-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n" +
                    "\t\t\t\ttext-align: center;\n" +
                    "\t\t\t\tcolor: #777;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\tbody h1 {\n" +
                    "\t\t\t\tfont-weight: 300;\n" +
                    "\t\t\t\tmargin-bottom: 0px;\n" +
                    "\t\t\t\tpadding-bottom: 0px;\n" +
                    "\t\t\t\tcolor: #000;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\tbody h3 {\n" +
                    "\t\t\t\tfont-weight: 300;\n" +
                    "\t\t\t\tmargin-top: 10px;\n" +
                    "\t\t\t\tmargin-bottom: 20px;\n" +
                    "\t\t\t\tfont-style: italic;\n" +
                    "\t\t\t\tcolor: #555;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\tbody a {\n" +
                    "\t\t\t\tcolor: #06f;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box {\n" +
                    "\t\t\t\tmax-width: 800px;\n" +
                    "\t\t\t\tmargin: auto;\n" +
                    "\t\t\t\tpadding: 30px;\n" +
                    "\t\t\t\tborder: 1px solid #eee;\n" +
                    "\t\t\t\tbox-shadow: 0 0 10px rgba(0, 0, 0, 0.15);\n" +
                    "\t\t\t\tfont-size: 16px;\n" +
                    "\t\t\t\tline-height: 24px;\n" +
                    "\t\t\t\tfont-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n" +
                    "\t\t\t\tcolor: #555;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table {\n" +
                    "\t\t\t\twidth: 100%;\n" +
                    "\t\t\t\tline-height: inherit;\n" +
                    "\t\t\t\ttext-align: left;\n" +
                    "\t\t\t\tborder-collapse: collapse;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table td {\n" +
                    "\t\t\t\tpadding: 5px;\n" +
                    "\t\t\t\tvertical-align: top;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr td:nth-child(2) {\n" +
                    "\t\t\t\ttext-align: right;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.top table td {\n" +
                    "\t\t\t\tpadding-bottom: 20px;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.top table td.title {\n" +
                    "\t\t\t\tfont-size: 45px;\n" +
                    "\t\t\t\tline-height: 45px;\n" +
                    "\t\t\t\tcolor: #333;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.information table td {\n" +
                    "\t\t\t\tpadding-bottom: 40px;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.heading td {\n" +
                    "\t\t\t\tbackground: #eee;\n" +
                    "\t\t\t\tborder-bottom: 1px solid #ddd;\n" +
                    "\t\t\t\tfont-weight: bold;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.details td {\n" +
                    "\t\t\t\tpadding-bottom: 20px;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.item td {\n" +
                    "\t\t\t\tborder-bottom: 1px solid #eee;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.item.last td {\n" +
                    "\t\t\t\tborder-bottom: none;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.invoice-box table tr.total td:nth-child(2) {\n" +
                    "\t\t\t\tborder-top: 2px solid #eee;\n" +
                    "\t\t\t\tfont-weight: bold;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t@media only screen and (max-width: 600px) {\n" +
                    "\t\t\t\t.invoice-box table tr.top table td {\n" +
                    "\t\t\t\t\twidth: 100%;\n" +
                    "\t\t\t\t\tdisplay: block;\n" +
                    "\t\t\t\t\ttext-align: center;\n" +
                    "\t\t\t\t}\n" +
                    "\n" +
                    "\t\t\t\t.invoice-box table tr.information table td {\n" +
                    "\t\t\t\t\twidth: 100%;\n" +
                    "\t\t\t\t\tdisplay: block;\n" +
                    "\t\t\t\t\ttext-align: center;\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}\n" +
                    "\t\t</style>\n" +
                    "\t</head>\n" +
                    "\n" +
                    "\t<body>\n" +
                    "\t\t<h1>A simple, clean, and responsive HTML invoice template</h1>\n" +
                    "\t\t<h3>Because sometimes, all you need is something simple.</h3>\n" +
                    "\t\tFind the code on <a href=\"https://github.com/sparksuite/simple-html-invoice-template\">GitHub</a>. Licensed under the\n" +
                    "\t\t<a href=\"http://opensource.org/licenses/MIT\" target=\"_blank\">MIT license</a>.<br /><br /><br />\n" +
                    "\n" +
                    "\t\t<div class=\"invoice-box\">\n" +
                    "\t\t\t<table>\n" +
                    "\t\t\t\t<tr class=\"top\">\n" +
                    "\t\t\t\t\t<td colspan=\"2\">\n" +
                    "\t\t\t\t\t\t<table>\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"title\">\n" +
                    "\t\t\t\t\t\t\t\t\t<img src=\"./images/logo.png\" alt=\"Company logo\" style=\"width: 100%; max-width: 300px\" />\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\n" +
                    "\t\t\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t\t\tInvoice #: 123<br />\n" +
                    "\t\t\t\t\t\t\t\t\tCreated: January 1, 2015<br />\n" +
                    "\t\t\t\t\t\t\t\t\tDue: February 1, 2015\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"information\">\n" +
                    "\t\t\t\t\t<td colspan=\"2\">\n" +
                    "\t\t\t\t\t\t<table>\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t\t\tSparksuite, Inc.<br />\n" +
                    "\t\t\t\t\t\t\t\t\t12345 Sunny Road<br />\n" +
                    "\t\t\t\t\t\t\t\t\tSunnyville, TX 12345\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\n" +
                    "\t\t\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t\t\tAcme Corp.<br />\n" +
                    "\t\t\t\t\t\t\t\t\tJohn Doe<br />\n" +
                    "\t\t\t\t\t\t\t\t\tjohn@example.com\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"heading\">\n" +
                    "\t\t\t\t\t<td>Payment Method</td>\n" +
                    "\n" +
                    "\t\t\t\t\t<td>Check #</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"details\">\n" +
                    "\t\t\t\t\t<td>Check</td>\n" +
                    "\n" +
                    "\t\t\t\t\t<td>1000</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"heading\">\n" +
                    "\t\t\t\t\t<td>Item</td>\n" +
                    "\n" +
                    "\t\t\t\t\t<td>Price</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"item\">\n" +
                    "\t\t\t\t\t<td>Website design</td>\n" +
                    "\n" +
                    "\t\t\t\t\t<td>\$300.00</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"item\">\n" +
                    "\t\t\t\t\t<td>Hosting (3 months)</td>\n" +
                    "\n" +
                    "\t\t\t\t\t<td>\$75.00</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"item last\">\n" +
                    "\t\t\t\t\t<td>Domain name (1 year)</td>\n" +
                    "\n" +
                    "\t\t\t\t\t<td>\$10.00</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t<tr class=\"total\">\n" +
                    "\t\t\t\t\t<td></td>\n" +
                    "\n" +
                    "\t\t\t\t\t<td>Total: \$385.00</td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t</table>\n" +
                    "\t\t</div>\n" +
                    "\t</body>\n" +
                    "</html>"
        wv.loadDataWithBaseURL("", html, mimeType, encoding, "");
        createWebPrintJob(wv)
    }

    private fun createWebPrintJob(webView: WebView) {
        (this?.getSystemService(PRINT_SERVICE) as? PrintManager)?.let { printManager ->
            val jobName = "${getString(R.string.app_name)} Document"
            val printAdapter = webView.createPrintDocumentAdapter(jobName)
            printManager.print(
                jobName,
                printAdapter,
                PrintAttributes.Builder().build()
            )
        }
    }
}