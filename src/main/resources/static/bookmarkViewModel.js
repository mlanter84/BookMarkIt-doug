/**
 * Created by 580782 on 11/29/2015.
 */

function Bookmark(data) {
    this.url = ko.observable(data.url);
    this.description = ko.observable(data.description);
}

function BookmarkListViewModel() {
    // Data
    var self = this;
    self.bookmarks = ko.observableArray([]);
    self.newBookmarkUrl = ko.observable();
    self.newBookmarkDescription = ko.observable();

    // operations
    self.addBookmark = function() {
        self.bookmarks.push(new Bookmark({url: this.newBookmarkUrl(), description: this.newBookmarkDescription()}));
    }
    self.save = function() {
        $.ajax("/")
    }

}