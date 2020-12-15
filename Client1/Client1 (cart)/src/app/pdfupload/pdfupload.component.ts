import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-pdfupload',
  templateUrl: './pdfupload.component.html',
  styleUrls: ['./pdfupload.component.css']
})
export class PdfuploadComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private router: Router,
    private service: UserService,
    private data: DataService) { }

  pdfbook: any;
  onSelectFile(event) {
    this.pdfbook = event.target.files[0];
  }
  booklist: any;
  name: any;
  pd: any;
  bookName: string;
  authname: string;
  ngOnInit() {
    let observableresult = this.data.listbooks();
    observableresult.subscribe((result) => {

      console.log(result);
      this.booklist = result;
      console.log(this.booklist)
    })


  }



  // 

  downpdf(bas: any, Bname: string) {
    console.log("in show")
    const linkSource = 'data:application/pdf;base64,' + bas + '\n';
    const downloadLink = document.createElement("a");
    const fileName = Bname;


    console.log(linkSource);

    downloadLink.href = linkSource;
    downloadLink.download = fileName;
    downloadLink.click();
  }

  showpdf(bas: any, Bname: any) {
    let pdfWindow = window.open('Bname')

    pdfWindow.document.write(
      "<iframe width='100%' height='100%' src='data:application/pdf;base64, " +
      encodeURI(bas) + "'></iframe>"
    )
  }

  addbook() {
    // this.pdfBlobConversion(this.pdfbook,"application/pdf");

    console.log(this.authname, this.pdfbook, this.bookName)


    let observable = this.data.addbook(this.authname, this.pdfbook, this.bookName);
    //console.log(observable);
    observable.subscribe((result) => {
      console.log(result);
      //alert('book saved');

      this.ngOnInit();
    })
  }

removepdf(id)
{

  let observable = this.data.deletepdf(id);
  //console.log(observable);
  observable.subscribe((result) => {
    console.log(result);
    //alert('book saved');

    this.ngOnInit();
  })
}




}

